package com.wangxiaolang.kafkadelaymessage.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class TargetTopicConsumer {
    @KafkaListener(topics = "target_topic")
    public void listen(String message) {
        System.out.println("处理消息: " + message);
    }
}