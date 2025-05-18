package com.example.demo.web.controller;

import com.example.demo.apiPayload.ApiResponse;
import com.example.demo.converter.MemberConverter;
import com.example.demo.domain.Member;
import com.example.demo.domain.mapping.MemberMission;
import com.example.demo.service.MissionService.*;
import com.example.demo.web.dto.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static com.example.demo.converter.MissionConverter.toMissionDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionController {

    private final MissionService missionService;

    @PostMapping("/{missionId}/challenge")
    public ApiResponse<MissionResponseDTO.memberMissionDTO> Mission(
            @PathVariable String store_id,
            @RequestBody @Valid MissionRequestDTO request){
        MemberMission member_mission = missionService.startMission(request);
        MissionResponseDTO.memberMissionDTO MissionDTO = toMissionDTO(member_mission);
        return ApiResponse.onSuccess(MissionDTO);
    }
}