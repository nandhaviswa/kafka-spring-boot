package com.nandha.kaftrans;

import org.apache.kafka.streams.processor.Processor;
import org.apache.kafka.streams.processor.ProcessorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NndaProcessor implements Processor {

    @Autowired
    private ProfileRepository repository;

    private ProcessorContext context;

    @Override
    public void init(ProcessorContext context) {
        this.context = context;
    }

    @Override
    public void process(Object o, Object o2) {
        User user=(User) o2;

        Profile profile =new Profile();
        profile.firstname=user.firstname;
        profile.lastname=user.lastname;
        repository.save(profile);
        
        context.forward(o,o2);
        context.commit();
    }

    @Override
    public void close() {

    }
}
