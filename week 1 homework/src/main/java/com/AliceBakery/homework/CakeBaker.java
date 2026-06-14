package com.AliceBakery.homework;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CakeBaker {
    private final Froasting froasting;
    private final Syrup syrup;

    public CakeBaker(
            @Qualifier("chocolatefroasting") Froasting froasting,
            @Qualifier("chocolatesyrup") Syrup syrup){
        this.froasting = froasting;
        this.syrup = syrup;
    }

    public void bakeCake(){
        System.out.println("Cake baked with : " + froasting.getFroastingType() + " and " + syrup.getSyrupType());
    }
}
