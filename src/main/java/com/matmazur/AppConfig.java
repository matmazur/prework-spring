package com.matmazur;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import java.util.Random;

@Configuration
@PropertySource("classpath:config.properties")
public class AppConfig {


    @Bean
    public static PropertySourcesPlaceholderConfigurer getPropertySourcesPlaceholderConfigurer(){
        return new PropertySourcesPlaceholderConfigurer();
    }



    @Bean
    @Qualifier("someNumber")
    public int getRandomNumber() {
        return new Random().nextInt(100);
    }
}
