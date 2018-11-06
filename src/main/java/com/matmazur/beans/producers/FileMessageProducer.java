package com.matmazur.beans.producers;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Component
@Producer(type = Producer.ProducerType.FILE)
public class FileMessageProducer implements MessageProducer {

    @Override
    public String produce() {

        List<String> lines = null;
        try {
            lines = Files.readAllLines(Paths.get("someFile.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String result = "";

        if (lines != null) {

            result = lines.stream().reduce(result, (x, y) -> x + "\n" + y);

        }

        return result;
    }
}
