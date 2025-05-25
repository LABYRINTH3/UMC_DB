package com.example.demo.validation.annotation;

import com.example.demo.validation.validator.PageCheck;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

public @interface CheckPage {
    @Documented
    @Constraint(validatedBy = PageCheck.class)
    @Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface ValidPage {

        String message() default "page는 1 이상의 정수";
        Class<?>[] groups() default {};
        Class<? extends Payload>[] payload() default {};
    }
}
