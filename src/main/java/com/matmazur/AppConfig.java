package com.matmazur;

import com.matmazur.beans.producers.FileMessageProducer;
import com.matmazur.datasource.DatabaseDatasource;
import com.matmazur.profiles.DevProfile;
import com.matmazur.profiles.ProductionProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Configuration
@PropertySource("classpath:config.properties")

public class AppConfig {

    @Autowired
    Environment env;

    @Bean
    @Profile("default")
    public DatabaseDatasource getDefaultDatasource() {
        return (() -> Arrays.asList("KasiaDefault", "BartekDefault"));
    }

    @Bean
    @DevProfile
    public DatabaseDatasource getH2Datasource() {
        return () -> Arrays.asList("one", "two", "trheree", "four");
    }

    @Bean
    @ProductionProfile
    public DatabaseDatasource getMysqlDatasource() {
        return new DatabaseDatasource() {
            @Override
            public List<String> getDatabase() {
                try {

                    String fileName = env.getProperty("fileName");

                    Path filePath = new File(getClass().getClassLoader().getResource(fileName).toURI()).toPath();

                    List<String> list = Files.readAllLines(filePath);
                    return list;
                } catch (URISyntaxException | IOException e) {
                    e.printStackTrace();
                }
                return new ArrayList<>();
            }
        };
    }

    @Bean
    @Qualifier("someNumber")
    public int getRandomNumber() {
        return new Random().nextInt(100);
    }
}
