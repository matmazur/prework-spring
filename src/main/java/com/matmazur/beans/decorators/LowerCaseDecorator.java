package com.matmazur.beans.decorators;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
public class LowerCaseDecorator implements TextDecorator {
    @Override
    public String decorate(String s) {
        return s.toLowerCase();
    }
}
