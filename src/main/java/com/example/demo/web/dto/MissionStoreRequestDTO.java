package com.example.demo.web.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class MissionStoreRequestDTO {

    @NotNull
    private Integer reward;
    @NotNull
    private LocalDate deadline;
    @NotNull
    private String missionSpec;
    @NotNull
    private Long storeId;

}