package com.matmazur.beans.decorators;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;

@Target({METHOD, TYPE, FIELD, PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Qualifier
public @interface Decorator {

    DecoratorType type();

    enum DecoratorType {
        DUMB, LOWER
    }

}
