package com.example.demo.service.ReviewService;

import com.example.demo.domain.Review;
import com.example.demo.web.dto.ReviewStore.StoreReviewRequestDTO;

public interface ReviewCommandService {

    Review createReview(StoreReviewRequestDTO body);

}