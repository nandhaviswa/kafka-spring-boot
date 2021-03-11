package com.nandha.kaftrans;

import org.apache.kafka.streams.processor.Processor;
import org.apache.kafka.streams.processor.ProcessorSupplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NndaProcessorSupplier2 implements ProcessorSupplier {

    @Autowired
    private NndaProcessor2 processor2;

    @Override
    public Processor get() {
        return processor2;
    }
}
