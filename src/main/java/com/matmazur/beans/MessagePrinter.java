package com.matmazur.beans;

import com.matmazur.beans.decorators.Decorator;
import com.matmazur.beans.decorators.Decorator.*;
import com.matmazur.beans.decorators.TextDecorator;
import com.matmazur.beans.producers.MessageProducer;
import com.matmazur.beans.producers.Producer;
import com.matmazur.beans.producers.TestItem1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class MessagePrinter {

    @Autowired
    public TestItem1 item;

    private MessageProducer producer;
    private TextDecorator decorator;

    public MessagePrinter() {
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

