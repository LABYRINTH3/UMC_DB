package com.example.demo.service.MemberService;

import com.example.demo.domain.mapping.MemberMission;
import org.springframework.data.domain.Page;

public interface MemberQueryService {
    public Page<MemberMission> getMyMissionList(Long memberId, Integer page);
}
