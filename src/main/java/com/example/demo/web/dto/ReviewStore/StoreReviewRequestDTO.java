package com.example.demo.web.dto.ReviewStore;

import com.example.demo.validation.annotation.ExistingStore;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class StoreReviewRequestDTO {

        @NotNull
        private String title;

        @NotNull
        private Float score;

        @NotNull
        private Long memberId;

        @ExistingStore
        private Long storeId;
}
