// src/main/java/com/example/demo/service/store/StoreQueryServiceImpl.java
package com.example.demo.service.StoreService;

import com.example.demo.domain.Member;
import com.example.demo.domain.Review;
import com.example.demo.domain.Store;
import com.example.demo.repository.ReviewRepository;
import com.example.demo.repository.MemberRepository;
import com.example.demo.repository.StoreRepository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StoreQueryServiceImpl implements StoreQueryService{

    private final StoreRepository storeRepository;

    private final MemberRepository memberRepository;
    private final ReviewRepository reviewRepository;

    @Override
    public Optional<Store> findStore(Long id) {
        return storeRepository.findById(id);
    }

    @Override
    public List<Store> findStoresByNameAndScore(String name, Float score) {
        List<Store> filteredStores = storeRepository.dynamicQueryWithBooleanBuilder(name, score);

        filteredStores.forEach(store -> System.out.println("Store: " + store));

        return filteredStores;
    }

    @Override
    public Page<Review> getReviewList(Long StoreId, Integer page) {

        Store store = storeRepository.findById(StoreId).get();

        Page<Review> StorePage = reviewRepository.findAllByStore(store, PageRequest.of(page, 10));
        return StorePage;
    }

    @Override
    public Page<Review> getMyReviewList(Long StoreId, Long MemberId, Integer page) {
        Store store = storeRepository.findById(StoreId).get();
        Member member = memberRepository.findById(MemberId).get();

        Page<Review> StorePage = reviewRepository.findAllByStoreAndMember(store,member,PageRequest.of(page, 10));
        return StorePage;
    }
}
