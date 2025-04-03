package com.wangxiaolang.kafkadelaymessage;

import com.wangxiaolang.kafkadelaymessage.entity.DelayMessage;
import com.wangxiaolang.kafkadelaymessage.producer.KafkaDelayProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaDelayMessageApplication implements CommandLineRunner {
    @Autowired
    private KafkaDelayProducer producer;

    public static void main(String[] args) {
        SpringApplication.run(KafkaDelayMessageApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        DelayMessage delayMessage = new DelayMessage("这是一条延迟消息", 5000);
        producer.sendDelayMessage(delayMessage);
    }
}