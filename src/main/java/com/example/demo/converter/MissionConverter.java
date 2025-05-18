package com.example.demo.converter;

import com.example.demo.domain.Member;
import com.example.demo.domain.Mission;
import com.example.demo.domain.enums.MissionStatus;
import com.example.demo.domain.mapping.MemberMission;
import com.example.demo.web.dto.MissionRequestDTO;
import com.example.demo.web.dto.MissionResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class MissionConverter {

    public static MemberMission toEntity(MissionRequestDTO request, Member member, Mission mission) {

        return MemberMission.builder()
                .status(MissionStatus.CHALLENGING)
                .member(member)
                .mission(mission)
                .build();
    }

    public static MissionResponseDTO.memberMissionDTO toMissionDTO(MemberMission memberMission) {

        return MissionResponseDTO.memberMissionDTO.builder()
                .id(memberMission.getId())
                .status(memberMission.getStatus())
                .memberId(memberMission.getMember().getId())
                .missionId(memberMission.getMission().getId())
                .build();
    }

}