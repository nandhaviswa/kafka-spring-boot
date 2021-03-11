package com.nandha.kaftrans.streams.processor;

import com.nandha.kaftrans.model.Person;
import com.nandha.kaftrans.model.User;
import com.nandha.kaftrans.mongorepo.UserRepository;
import org.apache.kafka.streams.processor.Processor;
import org.apache.kafka.streams.processor.ProcessorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserProcessor implements Processor {

    @Autowired
    private UserRepository repository;

    private ProcessorContext context;

    @Override
    public void init(ProcessorContext context) {
        this.context = context;
    }

    @Override
    public void process(Object o, Object o2) {
        Person person =(Person) o2;

        User user =new User();
        user.email= person.email;
        user.username= person.username;
        repository.save(user);

        person.age=person.age+11;
        context.forward(o,o2);
        context.commit();
    }

    @Override
    public void close() {

    }
}
