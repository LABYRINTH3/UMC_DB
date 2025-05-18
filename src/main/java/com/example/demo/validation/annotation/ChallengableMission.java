package com.example.demo.validation.annotation;

import com.example.demo.validation.validator.CategoriesExistValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;


import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CategoriesExistValidator.class)
@Target ({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ChallengableMission {

    String message() default "이미 도전 중이거나 존재하지 않는 미션입니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
