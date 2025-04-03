package com.wangxiaolang.kafkadelaymessage.consumer;


import com.wangxiaolang.kafkadelaymessage.timer.DelayTaskScheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class IntermediateTopicConsumer {
    @Autowired
    private DelayTaskScheduler scheduler;

    @KafkaListener(topics = "intermediate_topic")
    public void listen(String message) {
        System.out.println("zhongjian......");
        String[] parts = message.split(",");
        String msg = parts[0];
        long delayMs = Long.parseLong(parts[1]);
        scheduler.scheduleTask(msg, delayMs);
    }
}