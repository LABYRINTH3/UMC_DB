package com.example.demo.web.controller;

import com.example.demo.apiPayload.ApiResponse;
import com.example.demo.domain.Review;
import com.example.demo.service.ReviewService.ReviewCommandService;
import com.example.demo.web.dto.ReviewStore.StoreReviewRequestDTO;
import com.example.demo.web.dto.ReviewStore.StoreReviewResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static com.example.demo.converter.StoreReview.StoreReviewConverter.toReviewDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class ReviewController {

    private final ReviewCommandService reviewSvc;

    @PostMapping("/{storeId}/reviews")
    public ApiResponse<StoreReviewResponseDTO.ReviewDTO> create(
            @PathVariable Long storeId,
            @RequestBody @Valid StoreReviewResponseDTO body) {

        Review review = reviewSvc.createReview(body);
        StoreReviewResponseDTO.ReviewDTO reviewDTO = toReviewDTO(review);

        return ApiResponse.onSuccess(reviewDTO);
    }
}
