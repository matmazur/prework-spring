package com.matmazur.beans.producers;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class TestItem1 {

    public int number;

    public TestItem1() {
        number = new Random().nextInt(100);
    }
}
