package com.matmazur.beans.decorators;

import com.matmazur.beans.decorators.Decorator.*;
import org.springframework.stereotype.Component;

@Component
@Decorator(type = DecoratorType.LOWER)
public class LowerCaseDecorator implements TextDecorator {
    @Override
    public String decorate(String s) {
        return s.toLowerCase();
    }
}

