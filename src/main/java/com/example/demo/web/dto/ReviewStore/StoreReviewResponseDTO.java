package com.example.demo.web.dto.ReviewStore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class StoreReviewResponseDTO {


    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ReviewDTO {
        public Long id;
        public String title;
        public Float score;
        public String memberName;
        public String storeName;
    }
}