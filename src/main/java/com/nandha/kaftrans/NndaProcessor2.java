package com.nandha.kaftrans;

import org.apache.kafka.streams.processor.Processor;
import org.apache.kafka.streams.processor.ProcessorContext;
import org.springframework.stereotype.Component;

@Component
public class NndaProcessor2 implements Processor {

    private ProcessorContext context;

    @Override
    public void init(ProcessorContext context) {
        this.context = context;
    }

    @Override
    public void process(Object o, Object o2) {
        Person person =(Person) o2;
        person.age=99;
        context.forward(o,o2);
        context.commit();
    }

    @Override
    public void close() {

    }
}
