package com.matmazur.beans.decorators.qualifiers;


import org.springframework.beans.factory.annotation.Qualifier;

import static java.lang.annotation.ElementType.*;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target({METHOD, TYPE, FIELD, PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Qualifier
public @interface DumbDecorator {
}
