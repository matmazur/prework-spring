package com.matmazur.beans;

import org.springframework.stereotype.Component;

@Component
public class StringMessageProducer implements MessageProducer {

    @Override
    public String produce(String s) {
        return  s;
    }
}
