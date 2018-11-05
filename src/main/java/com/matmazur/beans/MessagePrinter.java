package com.matmazur.beans;

import org.springframework.stereotype.Component;

@Component
public class MessagePrinter {

    private MessageProducer producer;

    MessagePrinter() {
    }

    public MessagePrinter(MessageProducer producer) {
        this.producer = producer;
    }

    public MessageProducer getProducer() {
        return producer;
    }

    public void setProducer(MessageProducer producer) {
        this.producer = producer;
    }


    @Override
    public String toString() {
        return "com.matmazur.beans.MessagePrinter{" +
                "producer=" + producer +
                '}';
    }
}

