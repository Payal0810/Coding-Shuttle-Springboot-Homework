package com.AliceBakery.homework;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("chocolatefroasting")
public class ChocolateFroasting implements Froasting{
    @Override
    public String getFroastingType() {
        return "Chocolate Froasting";
    }
}
