package com.matmazur.beans.decorators;

import com.matmazur.beans.decorators.Decorator.*;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@Primary
@Decorator(type = DecoratorType.DUMB)
public class DumbTextDecorator implements TextDecorator {

    @Override
    public String decorate(String s) {

        s = s.toUpperCase();
        List<String> list = new ArrayList<>(Arrays.asList(s.split("")));
        list.add(".");

        String result = String.join(".", list)
                .replace(",. ", ", ")
                .replace(" .", " ")
                .replace("..", ".")
                .replace(".,", ". ,");

        while (result.endsWith(".")) {

            result = result.substring(0, result.length() - 1);
        }

        return result + ".";
    }
}
