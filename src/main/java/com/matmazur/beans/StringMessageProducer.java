package com.matmazur.beans;

public class StringMessageProducer implements MessageProducer {

    @Override
    public void produce(String s) {
        System.out.println(s);
    }
}
