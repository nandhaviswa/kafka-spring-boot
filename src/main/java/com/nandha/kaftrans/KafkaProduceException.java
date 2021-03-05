package com.nandha.kaftrans;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
 
@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR, reason="Transaction Aborted")
public class KafkaProduceException extends RuntimeException {
    public KafkaProduceException(String message){
        super(message);
    }
}