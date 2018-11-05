package com.matmazur.beans;

import com.matmazur.beans.decorators.Decorator;
import com.matmazur.beans.decorators.Decorator.*;
import com.matmazur.beans.decorators.TextDecorator;
import com.matmazur.beans.producers.MessageProducer;
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


    //@Qualifier("dumbTextDecorator") works aswell
    @Autowired(required = false)
    public void setDecorator(@Decorator(type = DecoratorType.LOWER) TextDecorator decorator) {
        this.decorator = decorator;
    }

    public String produce(String s) {

        return decorator != null ? producer.produce(decorator.decorate(s)) : producer.produce(s);
    }
}

