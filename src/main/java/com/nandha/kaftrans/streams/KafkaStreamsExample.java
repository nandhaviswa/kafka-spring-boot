package com.nandha.kaftrans.streams;

import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafkaStreams;
import org.springframework.kafka.config.StreamsBuilderFactoryBean;

@Configuration(proxyBeanMethods = false)
@EnableKafkaStreams
public class KafkaStreamsExample {
    
    public KafkaStreamsExample(StreamsBuilderFactoryBean myKStreamBuilderFactoryBean, PersonInfrastructure infrastructure){
        myKStreamBuilderFactoryBean.setInfrastructureCustomizer(infrastructure);
    }
}
