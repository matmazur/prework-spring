package com.matmazur.beans.producers;

import org.springframework.stereotype.Component;

@Component
public class StringMessageProducer implements MessageProducer {

    @Override
    public String produce() {
        return "This is a default string";
    }
}
