package com.example.demo.converter;

import com.example.demo.domain.Mission;
import com.example.demo.domain.Store;
import org.springframework.stereotype.Component;

@Component
public class MissionConverter {
    public static Mission toMission(MissionStoreRequest request, Store store){
        return Mission.builder()
                .reward(request.getReward())
                .deadline(request.getDeadline())
                .missionSpec(request.getMissionSpec())
                .store(store)
                .build();
    }
    public static MissionStoreResponse.createMissionDTO toMissionDTO(Mission mission){
        return MissionStoreResponse.createMissionDTO.builder()
                .id(mission.getId())
                .reward(mission.getReward())
                .deadline(mission.getDeadline())
                .missionSpec(mission.getMissionSpec())
                .storeId(mission.getStore().getId())
                .build();
    }
}