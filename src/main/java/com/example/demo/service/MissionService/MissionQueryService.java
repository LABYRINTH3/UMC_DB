package com.example.demo.service.MissionService;

import com.example.demo.domain.Mission;
import org.springframework.data.domain.Page;

public interface MissionQueryService {
    Page<Mission> getMissionsByStoreId(Long storeId, int pageIndex);
}