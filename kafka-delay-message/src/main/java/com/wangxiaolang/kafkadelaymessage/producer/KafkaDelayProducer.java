package com.wangxiaolang.kafkadelaymessage.producer;

import com.wangxiaolang.kafkadelaymessage.entity.DelayMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaDelayProducer {
    private static final String INTERMEDIATE_TOPIC = "intermediate_topic";
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendDelayMessage(DelayMessage delayMessage) {
        String message = delayMessage.getMessage();
        long delayMs = delayMessage.getDelayMs();
        String value = message + "," + delayMs;
        kafkaTemplate.send(INTERMEDIATE_TOPIC, value);
        System.out.println("producer......");
    }
}