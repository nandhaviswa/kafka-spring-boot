package com.nandha.kaftrans;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class KafkaJsonProducerConfig {
    /*@Bean*/
    public Map<String, Object> producerConfigs() {
        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        props.put(ProducerConfig.ENABLE_IDEMPOTENCE_CONFIG, "true");
        // See https://kafka.apache.org/documentation/#producerconfigs for more properties
        return props;
    }

    /*@Bean*/
    public ProducerFactory<String, Person> producerFactory() {
        return new DefaultKafkaProducerFactory<String, Person>(producerConfigs());
    }

    @Bean({"kafkaTemplate2"})
    public KafkaTemplate<String, Person> kafkaTemplate() {
        return new KafkaTemplate<String, Person>(producerFactory());
    }

    /*@Bean({"kafkaTransactionManager2"})
    public KafkaTransactionManager<String, Person> kafkaTransactionManager() {
        return new KafkaTransactionManager<String, Person>(producerFactory());
    }*/
}
