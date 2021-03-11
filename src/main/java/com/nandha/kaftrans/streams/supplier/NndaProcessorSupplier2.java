package com.nandha.kaftrans.streams.supplier;

import com.nandha.kaftrans.streams.processor.NndaProcessor2;
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
