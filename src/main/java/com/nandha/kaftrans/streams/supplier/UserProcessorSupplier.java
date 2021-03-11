package com.nandha.kaftrans.streams.supplier;

import com.nandha.kaftrans.streams.processor.UserProcessor;
import org.apache.kafka.streams.processor.Processor;
import org.apache.kafka.streams.processor.ProcessorSupplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserProcessorSupplier implements ProcessorSupplier {

    @Autowired
    private UserProcessor processor2;

    @Override
    public Processor get() {
        return processor2;
    }
}
