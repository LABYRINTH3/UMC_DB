package com.example.demo.service.MissionService;

import com.example.demo.converter.MissionConverter;
import com.example.demo.domain.Member;
import com.example.demo.domain.Mission;
import com.example.demo.domain.Store;
import com.example.demo.domain.mapping.MemberMission;
import com.example.demo.repository.MemberMissionRepository;
import com.example.demo.repository.MemberRepository;
import com.example.demo.repository.MissionRepository;
import com.example.demo.repository.StoreRepository.StoreRepository;
import com.example.demo.service.StoreService.StoreQueryService;
import com.example.demo.web.dto.MissionRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionServiceImpl implements MissionService {

    private final MemberMissionRepository memberMissionRepository;
    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;

    @Override
    public MemberMission startMission(MissionRequestDTO request) {

        Member member = memberRepository.findById(request.getMemberId())
                .orElseThrow(() -> new RuntimeException("회원이 없습니다."));
        Mission mission = missionRepository.findById(request.getMissionId())
                .orElseThrow(() -> new RuntimeException("미션이 없습니다."));

        MemberMission newMemMission = MissionConverter.toEntity(request,member,mission);
        return memberMissionRepository.save(newMemMission);
    }
}