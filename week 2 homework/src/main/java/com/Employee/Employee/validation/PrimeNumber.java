package com.Employee.Employee.validation;

import jakarta.validation.Constraint;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PrimeValidator.class)
public @interface PrimeNumber {
    String message()
            default "Not a prime number";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload()
            default {};


}
