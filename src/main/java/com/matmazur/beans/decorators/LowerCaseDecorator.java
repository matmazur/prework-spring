package com.matmazur.beans.decorators;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Qualifier("lowerCaseDecorator")
@Component
public class LowerCaseDecorator implements TextDecorator {
    @Override
    public String decorate(String s) {
        return s.toLowerCase();
    }
}
