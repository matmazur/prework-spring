package com.matmazur.app;

import com.matmazur.beans.MessagePrinter;
import com.matmazur.beans.MessageProducer;
import com.matmazur.beans.StringMessageProducer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MessagePrinter getPrinter() {
        MessageProducer producer = new StringMessageProducer();
        return new MessagePrinter(producer);
    }


}
