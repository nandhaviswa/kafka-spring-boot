package com.nandha.kaftrans;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import com.nandha.kaftrans.KafkaProduceException;

@RestController
public class KafkaProduceController {

    static final String TOPIC_NAME = "user";

    @Autowired
    private KafkaTemplate<String, String> template;

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
}