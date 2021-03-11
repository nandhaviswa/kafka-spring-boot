package com.nandha.kaftrans.streams.supplier;

import com.nandha.kaftrans.streams.processor.ProfileProcessor;
import org.apache.kafka.streams.processor.Processor;
import org.apache.kafka.streams.processor.ProcessorSupplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NndaProcessorSupplier implements ProcessorSupplier {

    @Autowired
    private ProfileProcessor processor;

    @Override
    public Processor get() {
        return processor;
    }
}
