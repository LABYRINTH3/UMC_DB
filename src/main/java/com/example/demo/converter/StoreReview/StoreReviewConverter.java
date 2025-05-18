package com.example.demo.converter.StoreReview;

import com.example.demo.domain.Member;
import com.example.demo.domain.Review;
import com.example.demo.domain.Store;
import com.example.demo.web.dto.ReviewStore.*;
import org.springframework.stereotype.Component;

@Component
public class StoreReviewConverter {

    public static Review toReview (StoreReviewRequestDTO request, Member member, Store store) {

        return Review.builder()
                .title(request.getTitle())
                .score(request.getScore())
                .member(member)
                .store(store)
                .build();
    }

    public static StoreReviewResponseDTO.ReviewDTO toReviewDTO (Review review) {

        return StoreReviewResponseDTO.ReviewDTO.builder()
                .id(review.getId())
                .title(review.getTitle())
                .score(review.getScore())
                .memberName(review.getMember().getName())
                .storeName(review.getStore().getName())
                .build();

    }
}