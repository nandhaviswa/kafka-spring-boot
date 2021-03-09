package com.nandha.kaftrans;

import org.apache.kafka.streams.processor.Processor;
import org.apache.kafka.streams.processor.ProcessorContext;

public class NndaProcessor implements Processor {

    private ProcessorContext context;

    @Override
    public void init(ProcessorContext context) {
        this.context = context;
    }

    @Override
    public void process(Object o, Object o2) {
        User user=(User) o2;
        user.age=18;
        context.forward(o,o2);
        context.commit();
    }

    @Override
    public void close() {

    }
}
