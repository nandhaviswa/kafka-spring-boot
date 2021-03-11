package com.nandha.kaftrans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
public class KafkaProduceController {

    static final String TOPIC_NAME = "tmp";

    @Autowired
    private KafkaTemplate<String, String> template;

    @Autowired
    private KafkaTemplate<String, Person> template2;

    @GetMapping("/send")
    public String send(
        @RequestParam(defaultValue = "foo") String key, 
        @RequestParam(defaultValue = "bar") String value, 
        @RequestParam(defaultValue = "false") String fail) throws KafkaProduceException {
        template.executeInTransaction(tpl -> {
            template.send(TOPIC_NAME,key,value);
            if(fail.equals("true")){
                throw new KafkaProduceException("hello world!");
            }
            return true;
        });
        return "success";
    }

    @Transactional
    @GetMapping("/send2")
    public String send2(
        @RequestParam(defaultValue = "foo") String key, 
        @RequestParam(defaultValue = "bar") String value, 
        @RequestParam(defaultValue = "false") String fail) throws KafkaProduceException {
        template.send(TOPIC_NAME,key,value);
        if(fail.equals("true")){
            throw new KafkaProduceException("hello world!");
        }
        return "success";
    }

    @PostMapping("/send3")
    public String send3(@RequestParam(defaultValue = "foo") String key, @RequestBody Person person){
        template2.send("person", key, person);
        return "success";
    }
}