package com.example.demo.service.MissionService;

import com.example.demo.domain.Mission;
import com.example.demo.web.dto.MissionStoreRequestDTO;

public interface MissionService {

    Mission createMission(MissionStoreRequestDTO request);
}