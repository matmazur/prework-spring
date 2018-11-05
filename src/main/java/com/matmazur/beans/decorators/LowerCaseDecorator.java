package com.matmazur.beans.decorators;

import com.matmazur.beans.decorators.qualifiers.LowerDecorator;
import org.springframework.stereotype.Component;

@Component
@LowerDecorator
public class LowerCaseDecorator implements TextDecorator {
    @Override
    public String decorate(String s) {
        return s.toLowerCase();
    }
}

