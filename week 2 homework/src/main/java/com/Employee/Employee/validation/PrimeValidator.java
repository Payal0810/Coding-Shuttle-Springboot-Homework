package com.Employee.Employee.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PrimeValidator implements ConstraintValidator<PrimeNumber, Integer> {

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        if(value==null){
            return true;
        }

        if(value<=1){
            return false;
        }

        for(int i =2; i<=Math.sqrt(value); i++){
            if(value%i==0){
                return false;
            }
        }

        return true;
    }
}
