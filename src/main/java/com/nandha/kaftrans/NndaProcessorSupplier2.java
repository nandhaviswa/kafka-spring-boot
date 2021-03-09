package com.nandha.kaftrans;

import org.apache.kafka.streams.processor.Processor;
import org.apache.kafka.streams.processor.ProcessorSupplier;

public class NndaProcessorSupplier2 implements ProcessorSupplier {
    @Override
    public Processor get() {
        return new NndaProcessor2();
    }
}
