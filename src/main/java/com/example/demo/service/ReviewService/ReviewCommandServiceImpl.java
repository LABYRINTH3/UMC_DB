package com.example.demo.service.ReviewService;

import com.example.demo.converter.StoreReview.StoreConverter;
import com.example.demo.domain.Member;
import com.example.demo.domain.Review;
import com.example.demo.domain.Store;
import com.example.demo.repository.MemberRepository;
import com.example.demo.repository.ReviewRepository;
import com.example.demo.repository.StoreRepository.StoreRepository;
import com.example.demo.web.dto.ReviewStore.StoreRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService {

    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;
    private final StoreRepository storeRepository;

    @Override
    public Review createReview(StoreRequestDTO request) {

        Member member = memberRepository.findById(request.getMemberId())
                .orElseThrow(() -> new RuntimeException("회원 없음"));
        Store store = storeRepository.findById(request.getStoreId())
                .orElseThrow(() -> new RuntimeException("가게 없음"));

        Review newReview = StoreConverter.toReview(request,member,store);
        return reviewRepository.save(newReview);
    }








}