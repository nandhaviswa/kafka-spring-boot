package com.nandha.kaftrans;

import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@EnableKafka
@Component
public class KafkaConsumer {

    @KafkaListener(topics = "person_out")
    public void processMessage(String content) {

        System.out.println("\n--------------------------------[ nandha ]---------------------------------\n");
        System.out.println(content);
        System.out.println("\n--------------------------------[ nandha ]---------------------------------\n");

    }
}
