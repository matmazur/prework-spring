package com.matmazur.beans;

import com.matmazur.beans.decorators.Decorator;
import com.matmazur.beans.decorators.Decorator.*;
import com.matmazur.beans.decorators.TextDecorator;
import com.matmazur.beans.producers.MessageProducer;
import com.matmazur.beans.producers.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessagePrinter {

    private MessageProducer producer;
    private TextDecorator decorator;

    MessagePrinter() {
    }

    @Autowired
    public MessagePrinter(@Producer(type = Producer.ProducerType.FILE) MessageProducer producer) {
        this.producer = producer;
    }

    @Autowired(required = false)
    public void setDecorator(@Decorator(type = DecoratorType.LOWER) TextDecorator decorator) {
        this.decorator = decorator;
    }

    public String produce() {

        return decorator != null ? decorator.decorate(producer.produce()) : producer.produce();
    }
}

