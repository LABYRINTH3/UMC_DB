package com.example.demo.service.MissionService;

import com.example.demo.domain.mapping.MemberMission;
import com.example.demo.web.dto.MissionRequestDTO;

public interface MissionService {

    MemberMission startMission(MissionRequestDTO request);
}