package com.nandha.kaftrans;

import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.apache.kafka.streams.Topology;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.config.KafkaStreamsInfrastructureCustomizer;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;
import org.springframework.stereotype.Component;

@Component
public class NndaInfrastructure implements KafkaStreamsInfrastructureCustomizer {

    @Autowired
    private NndaProcessorSupplier processSupplier1;

    @Autowired
    private NndaProcessorSupplier2 processSupplier2;

    @Override
    public void configureTopology(Topology topology) {
        JsonDeserializer<User> thingDeserializer = new JsonDeserializer<>(User.class);
        StringDeserializer stringDeserializer = new StringDeserializer();
        topology.addSource("source1", stringDeserializer, thingDeserializer, "user");
        
        topology.addProcessor("processor1", processSupplier1,"source1");
        topology.addProcessor("processor2", processSupplier2,"processor1");

        topology.addSink("sink1","user_out", new StringSerializer(), new JsonSerializer<User>(),"processor2");
    }
}
