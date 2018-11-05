package com.matmazur.app;

import com.matmazur.beans.MessagePrinter;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans-config.xml");

        MessagePrinter printer = context.getBean(MessagePrinter.class);

        printer.getProducer().produce("Stuff, things.");

        context.close();

    }
}
