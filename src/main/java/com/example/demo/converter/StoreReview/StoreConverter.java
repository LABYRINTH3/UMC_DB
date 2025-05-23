package com.example.demo.converter.StoreReview;

import com.example.demo.domain.Member;
import com.example.demo.domain.Review;
import com.example.demo.domain.Store;
import com.example.demo.web.dto.ReviewStore.*;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class StoreConverter {

    public static Review toReview (StoreRequestDTO request, Member member, Store store) {

        return Review.builder()
                .title(request.getTitle())
                .score(request.getScore())
                .member(member)
                .store(store)
                .build();
    }

    public static StoreResponseDTO.ReviewDTO toReviewDTO (Review review) {

        return StoreResponseDTO.ReviewDTO.builder()
                .id(review.getId())
                .title(review.getTitle())
                .score(review.getScore())
                .memberName(review.getMember().getName())
                .storeName(review.getStore().getName())
                .build();

    }

    public static StoreResponseDTO.ReviewPreViewDTO reviewPreViewDTO(Review review){
        return StoreResponseDTO.ReviewPreViewDTO.builder()
                .ownerNickname(review.getMember().getName())
                .score(review.getScore())
                .createdAt(review.getCreatedAt().toLocalDate())
                .body(review.getBody())
                .build();
    }
    public static StoreResponseDTO.ReviewPreViewListDTO reviewPreViewListDTO(Page<Review> reviewList){

        List<StoreResponseDTO.ReviewPreViewDTO> reviewPreViewDTOList = reviewList.stream()
                .map(StoreConverter::reviewPreViewDTO).collect(Collectors.toList());

        return StoreResponseDTO.ReviewPreViewListDTO.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(reviewPreViewDTOList.size())
                .reviewList(reviewPreViewDTOList)
                .build();
    }

}