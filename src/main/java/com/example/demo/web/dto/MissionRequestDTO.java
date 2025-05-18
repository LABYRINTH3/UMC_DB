package com.example.demo.web.dto;

import com.example.demo.validation.annotation.ExistCategories;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

import java.util.List;

public class MissionRequestDTO {

    @NotNull
    private Long memberId;

    @NotNull
    private Long missionId;

}
