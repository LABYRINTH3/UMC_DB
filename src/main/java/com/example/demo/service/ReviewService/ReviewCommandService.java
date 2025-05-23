package com.example.demo.service.ReviewService;

import com.example.demo.domain.Review;
import com.example.demo.web.dto.ReviewStore.StoreRequestDTO;

public interface ReviewCommandService {

    Review createReview(StoreRequestDTO body);

}