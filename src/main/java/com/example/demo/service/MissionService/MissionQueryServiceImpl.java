package com.example.demo.service.MissionService;

import com.example.demo.domain.Mission;
import com.example.demo.repository.MissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MissionQueryServiceImpl implements MissionQueryService {

    private final MissionRepository missionRepository;

    @Override
    public Page<Mission> getMissionsByStoreId(Long storeId, int pageIndex) {
        Pageable pageable = PageRequest.of(pageIndex, 10, Sort.by("createdAt").descending());
        return missionRepository.findAllByStoreId(storeId, pageable);
    }
}