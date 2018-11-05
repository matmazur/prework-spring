package com.matmazur.beans;

import org.springframework.stereotype.Component;

@Component
public class StringMessageProducer implements MessageProducer {

    @Override
    public void produce(String s) {
        System.out.println("String of the day is : " + s);
    }
}
