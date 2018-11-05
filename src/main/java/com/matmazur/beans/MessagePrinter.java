package com.matmazur.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessagePrinter {

    private MessageProducer producer;
    private TextDecorator decorator;

    MessagePrinter() {
    }

    @Autowired
    public MessagePrinter(MessageProducer producer) {
        this.producer = producer;
    }



    @Autowired
    public void setDecorator(TextDecorator decorator) {
        this.decorator = decorator;
    }

    public void produce(String s) {
        producer.produce(s);
    }

    public String decorate(String s){
        return decorator.decorate(s);
    }



}

