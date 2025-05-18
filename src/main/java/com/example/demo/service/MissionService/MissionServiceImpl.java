package com.example.demo.service.MissionService;

import com.example.demo.domain.Mission;
import com.example.demo.domain.Store;
import com.example.demo.repository.StoreRepository.StoreRepository;
import com.example.demo.web.dto.MissionStoreRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MissionServiceImpl implements MissionService {

    private final StoreRepository storeRepository;
    private final MissionRepository missionRepository;

    @Override
    public Mission createMission(MissionStoreRequestDTO request) {

        Store store = storeRepository.findById(request.getStoreId())
                .orElseThrow(() -> new RuntimeException("Store not found"));

        Mission newMission = MissionStoreConverter.toMission(request,store);
        return missionRepository.save(newMission);
    }
}