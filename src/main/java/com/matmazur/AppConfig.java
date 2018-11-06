package com.matmazur;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Random;

@Configuration
public class AppConfig {

    @Bean
    @Qualifier("someNumber")
    public int getRandomNumber() {
        return new Random().nextInt(100);
    }
}
