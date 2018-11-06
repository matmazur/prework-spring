package com.matmazur;

import com.matmazur.beans.MessagePrinter;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class Main {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);

        MessagePrinter printer = context.getBean(MessagePrinter.class);

        String x = printer.produce();
        System.out.println(x);

        context.close();
    }
}
