package com.matmazur.beans.producers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
@Producer(type = Producer.ProducerType.SIMPLE)
public class StringMessageProducer implements MessageProducer {

    @Autowired
    @Qualifier("someNumber")
    private int number;

    @Override
    public String produce() {
        return "This is a default string with a number " + number;
    }
}
