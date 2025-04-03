package com.wangxiaolang.kafkadelaymessage.mapper;

import com.wangxiaolang.kafkadelaymessage.entity.DelayMessage;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: ZuoYu Wang
 * @create: 2025年04月03日 17:31
 **/
@Component
public class TaskRepository {

    public List<DelayMessage> getUncompletedTasks() {
        return new ArrayList<>();
    }

    public void saveTask(String message, long delayMs) {
    }

    public void markTaskAsCompleted(String message) {
    }
}