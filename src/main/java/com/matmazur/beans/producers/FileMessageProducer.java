package com.matmazur.beans.producers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Component
@Producer(type = Producer.ProducerType.FILE)
public class FileMessageProducer implements MessageProducer {


    @Autowired
    Environment env;

    @Override
    public String produce() {

        String fileName = env.getProperty("fileName");

        List<String> lines = null;
        try {
            if (fileName != null) {
                Path path = new File(getClass().getClassLoader().getResource(fileName).toURI()).toPath();
                lines = Files.readAllLines(path);
            }
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }


        String result = "";

        if (lines != null) {
            result = lines.stream().reduce(result, (x, y) -> x + "\n" + y);
        }
        return result;
    }
}
