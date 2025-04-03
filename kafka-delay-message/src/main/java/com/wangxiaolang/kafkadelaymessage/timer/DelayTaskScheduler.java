package com.wangxiaolang.kafkadelaymessage.timer;

import com.wangxiaolang.kafkadelaymessage.entity.DelayMessage;
import com.wangxiaolang.kafkadelaymessage.mapper.TaskRepository;
import io.netty.util.HashedWheelTimer;
import io.netty.util.Timeout;
import io.netty.util.TimerTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;
import java.util.concurrent.TimeUnit;


@Component
public class DelayTaskScheduler {
    private static final String TARGET_TOPIC = "target_topic";
    /**
     * tickDuration * ticksWheel > 需要延迟的时间
     */
    private final HashedWheelTimer timer = new HashedWheelTimer(30L, TimeUnit.SECONDS,2048);
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    @Autowired
    private TaskRepository taskRepository; // 自定义的数据库操作类

    @PostConstruct
    public void init() {
        // 服务重启后，从数据库中读取未执行的任务
        List<DelayMessage> tasks = taskRepository.getUncompletedTasks();
        for (DelayMessage task : tasks) {
            long delayMs = task.getDelayMs() - (System.currentTimeMillis() - task.getCreateTime());
            if (delayMs > 0) {
                scheduleTask(task.getMessage(), delayMs);
            }
        }
    }

    public void scheduleTask(String message, long delayMs) {
        // 存储任务到数据库
        taskRepository.saveTask(message, delayMs);
        timer.newTimeout(new TimerTask() {
            @Override
            public void run(Timeout timeout) throws Exception {
                kafkaTemplate.send(TARGET_TOPIC, message);
                // 任务执行完成后，标记为已完成
                taskRepository.markTaskAsCompleted(message);
            }
        }, delayMs, java.util.concurrent.TimeUnit.MILLISECONDS);
    }

    @PreDestroy
    public void close() {
        timer.stop();
    }
}