package com.matmazur.app;

import com.matmazur.beans.MessagePrinter;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        MessagePrinter printer = context.getBean(MessagePrinter.class);

        printer.getProducer().produce("Stuff, things.");

        context.close();

    }
}
