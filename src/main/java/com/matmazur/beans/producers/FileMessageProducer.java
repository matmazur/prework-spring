package com.matmazur.beans.producers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
    @Qualifier("messageFile")
    private  String fileName;

    @Override
    public String produce() {

        ClassLoader classLoader = FileMessageProducer.class.getClassLoader();

        List<String> lines = null;
        try {
            Path path = new File(classLoader.getResource(fileName).toURI()).toPath();
            lines = Files.readAllLines(path);
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
