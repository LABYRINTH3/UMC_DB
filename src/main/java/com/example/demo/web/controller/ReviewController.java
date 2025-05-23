package com.example.demo.web.controller;



import com.example.demo.apiPayload.ApiResponse;
import com.example.demo.domain.Review;
import com.example.demo.service.ReviewService.ReviewCommandService;
import com.example.demo.web.dto.ReviewStore.StoreRequestDTO;
import com.example.demo.web.dto.ReviewStore.StoreResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static com.example.demo.converter.StoreReview.StoreConverter.toReviewDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class ReviewController {

    private final ReviewCommandService reviewSvc;

    @PostMapping("/{storeId}/reviews")
    public ApiResponse<StoreResponseDTO.ReviewDTO> create(
            @PathVariable Long storeId,
            @RequestBody @Valid StoreRequestDTO body) {

        Review review = reviewSvc.createReview(body);
        StoreResponseDTO.ReviewDTO reviewDTO = toReviewDTO(review);

        return ApiResponse.onSuccess(reviewDTO);
    }
}
