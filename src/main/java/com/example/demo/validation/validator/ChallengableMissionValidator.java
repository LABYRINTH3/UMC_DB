package com.example.demo.validation.validator;

import com.example.demo.apiPayload.code.status.ErrorStatus;
import com.example.demo.domain.enums.MissionStatus;
import com.example.demo.repository.FoodCategoryRepository;
import com.example.demo.service.MissionService.MissionService;
import com.example.demo.validation.annotation.ChallengableMission;
import com.example.demo.validation.annotation.ExistCategories;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ChallengableMissionValidator implements ConstraintValidator<ChallengableMission, MissionStatus> {

    private MissionService missionService;

    @Override
    public void initialize(ChallengableMission constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(MissionStatus status, ConstraintValidatorContext context) {

        boolean result = false;

        if (status == MissionStatus.CHALLENGING) {
            result = true;
        } else if (status == MissionStatus.COMPLETE) {
            result = false;
        }

        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate(ErrorStatus.MISSON_COMPLETED_BEFORE.toString()).addConstraintViolation();

        return result;
    }
}