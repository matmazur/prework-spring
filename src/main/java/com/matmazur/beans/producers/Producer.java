package com.matmazur.beans.producers;


import org.springframework.beans.factory.annotation.Qualifier;

import static java.lang.annotation.ElementType.*;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@Target({FIELD, PARAMETER, METHOD, TYPE})
public @interface Producer {


    ProducerType type();

    enum ProducerType {
        FILE, SIMPLE
    }

}
