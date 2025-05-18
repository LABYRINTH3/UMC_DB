// src/main/java/com/example/demo/service/store/StoreQueryServiceImpl.java
package com.example.demo.service.store;

import com.example.demo.domain.Store;
import com.example.demo.repository.store.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StoreQueryServiceImpl implements StoreQueryService {

    private final StoreRepository storeRepository;

    @Override
    public Optional<Store> findStore(Long id) {
        return storeRepository.findById(id);
    }

    @Override
    public List<Store> findStoresByNameAndScore(String name, Float score) {
        return storeRepository.dynamicQueryWithBooleanBuilder(name, score);
    }
}
