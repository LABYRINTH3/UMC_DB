package com.example.demo.converter;

import org.springframework.data.domain.Page;
import com.example.demo.domain.Mission;
import com.example.demo.domain.Store;
import com.example.demo.web.dto.MissionRequestDTO;
import com.example.demo.web.dto.MissionResponseDTO;

import java.util.List;

public class MissionConverter {
    public static Mission toMission(MissionRequestDTO dto, Store store) {
        return Mission.builder()
                .reward(dto.getReward())
                .missionSpec(dto.getMissionSpec())
                .store(store)
                .build();
    }

    public static MissionResponseDTO toResponseDTO(Mission mission) {
        return MissionResponseDTO.builder()
                .missionId(mission.getId())
                .storeId(mission.getStore().getId())
                .reward(mission.getReward())
                .missionSpec(mission.getMissionSpec())
                .build();
    }

    public static MissionResponseDTO.MissionPreviewDTO toMissionPreviewDTO(Mission mission) {
        return MissionResponseDTO.MissionPreviewDTO.builder()
                .missionId(mission.getId())
                .storeId(mission.getStore().getId())
                .reward(mission.getReward())
                .missionSpec(mission.getMissionSpec())
                .createdAt(mission.getCreatedAt())
                .build();
    }

    public static MissionResponseDTO.MissionListDTO toMissionListDTO(Page<Mission> missionPage) {
        List<MissionResponseDTO.MissionPreviewDTO> dtoList = missionPage.getContent().stream()
                .map(MissionConverter::toMissionPreviewDTO)
                .toList();

        return MissionResponseDTO.MissionListDTO.builder()
                .missionList(dtoList)
                .listSize(dtoList.size())
                .totalPage(missionPage.getTotalPages())
                .totalElements(missionPage.getTotalElements())
                .isFirst(missionPage.isFirst())
                .isLast(missionPage.isLast())
                .build();
    }
}