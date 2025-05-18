package com.example.demo.web.controller;

import com.example.demo.apiPayload.ApiResponse;
import com.example.demo.domain.Mission;
import com.example.demo.web.dto.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class MissionController {

    private final CreateMissionService createMissionService;

    @PostMapping("/{store_id}/missions")
    public ApiResponse<MissionStoreResponseDTO.createMissionDTO> createMission
            (@PathVariable("store_id") String storeId,
             @Valid @RequestBody MissionStoreRequestDTO request) {
        Mission newMission = createMissionService.createMission(request);
        MissionStoreResponse.createMissionDTO missionDTO = toMissionDTO(newMission);

        return ApiResponse.onSuccess(missionDTO);
    }

}