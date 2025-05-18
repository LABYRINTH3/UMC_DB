package com.example.demo.web.dto;

import com.example.demo.domain.enums.MissionStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class MissionResponseDTO {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class memberMissionDTO {

        private Long id;
        private MissionStatus status;
        private Long memberId;
        private Long missionId;

    }
}