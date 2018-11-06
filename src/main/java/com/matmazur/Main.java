package com.matmazur;

import com.matmazur.beans.MessagePrinter;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan
@PropertySource("classpath:config.properties")
public class Main {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);

        MessagePrinter printer = context.getBean(MessagePrinter.class);

        String x = printer.produce();
        System.out.println(x);

        MessagePrinter printer1 = context.getBean(MessagePrinter.class);
        MessagePrinter printer2 = context.getBean(MessagePrinter.class);

        System.out.println(printer1.item.number);
        System.out.println(printer2.item.number);












        context.close();
    }

}
