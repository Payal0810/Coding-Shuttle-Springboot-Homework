package com.AliceBakery.homework;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("strawberryfroasting")
public class StrawberryFroasting implements Froasting{
    @Override
    public String getFroastingType() {
        return "Strawberry Froasting";
    }
}
