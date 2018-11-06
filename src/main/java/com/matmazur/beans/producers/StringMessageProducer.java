package com.matmazur.beans.producers;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
@Producer(type = Producer.ProducerType.SIMPLE)
public class StringMessageProducer implements MessageProducer {

    @Override
    public String produce() {
        return "This is a default string";
    }
}
