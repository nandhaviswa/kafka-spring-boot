package com.nandha.kaftrans;

import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.Topology;
import org.springframework.kafka.config.KafkaStreamsInfrastructureCustomizer;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;

public class NndaInfrastructure implements KafkaStreamsInfrastructureCustomizer {

    @Override
    public void configureBuilder(StreamsBuilder builder) {
        System.out.println("\n--------------------------------[ nandha ]---------------------------------\n");
        System.out.println(builder);
        System.out.println("\n--------------------------------[ nandha ]---------------------------------\n");        
    }

    @Override
    public void configureTopology(Topology topology) {
        JsonDeserializer<User> thingDeserializer = new JsonDeserializer<>(User.class);
        StringDeserializer stringDeserializer = new StringDeserializer();
        topology.addSource("source1", stringDeserializer, thingDeserializer, "user");
        
        topology.addProcessor("processor1",new NndaProcessorSupplier(),"source1");
        topology.addProcessor("processor2",new NndaProcessorSupplier2(),"processor1");

        topology.addSink("sink1","user_out", new StringSerializer(), new JsonSerializer<User>(),"processor2");
    }
}
