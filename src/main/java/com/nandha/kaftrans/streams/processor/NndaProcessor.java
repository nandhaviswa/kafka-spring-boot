package com.nandha.kaftrans.streams.processor;

import com.nandha.kaftrans.model.Person;
import com.nandha.kaftrans.model.Profile;
import com.nandha.kaftrans.mongorepos.ProfileRepository;
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
        Person person =(Person) o2;

        Profile profile =new Profile();
        profile.firstname= person.firstname;
        profile.lastname= person.lastname;
        repository.save(profile);

        person.age=person.age+11;
        context.forward(o,o2);
        context.commit();
    }

    @Override
    public void close() {

    }
}
