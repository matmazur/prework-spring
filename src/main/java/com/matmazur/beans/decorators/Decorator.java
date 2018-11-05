package com.matmazur.beans.decorators;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

@Target({METHOD, TYPE, FIELD, PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Qualifier
public @interface Decorator {

    DecoratorType type();


    public enum DecoratorType {
        DUMB, LOWER;
    }

}
