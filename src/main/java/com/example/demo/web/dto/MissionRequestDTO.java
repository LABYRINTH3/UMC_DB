package com.example.demo.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MissionRequestDTO {

    @NotNull(message = "보상이 비어있습니다.")
    private Integer reward;

    @NotBlank(message = "미션 설명이 공백입니다.")
    private String missionSpec;
}