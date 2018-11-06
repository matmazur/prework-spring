package com.matmazur;

import com.matmazur.beans.MessagePrinter;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.List;

@Configuration
@ComponentScan
@PropertySource("classpath:config.properties")
public class Main {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);

        MessagePrinter printer = context.getBean(MessagePrinter.class);

        TestRepository repo = context.getBean(TestRepository.class);
        List<String> list = repo.getAll();

        list.forEach(System.out::println);

        context.close();
    }
}
