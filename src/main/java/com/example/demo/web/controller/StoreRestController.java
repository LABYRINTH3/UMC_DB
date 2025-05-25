package com.example.demo.web.controller;

import com.example.demo.apiPayload.ApiResponse;
import com.example.demo.converter.MissionConverter;
import com.example.demo.converter.StoreReview.StoreConverter;
import com.example.demo.domain.Mission;
import com.example.demo.domain.Review;
import com.example.demo.service.MissionService.MissionQueryServiceImpl;
import com.example.demo.service.StoreService.StoreQueryService;
import com.example.demo.service.MissionService.MissionQueryService;
import com.example.demo.validation.annotation.CheckPage;
import com.example.demo.web.dto.MissionResponseDTO;
import com.example.demo.web.dto.ReviewStore.StoreResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/stores")
public class StoreRestController {

    private final StoreQueryService storeQueryService;
    private final MissionQueryServiceImpl missionQueryService;

    @GetMapping("/{storeId}/reviews")
    @Operation(summary = "특정 가게의 리뷰 목록 조회 API",description = "특정 가게의 리뷰들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "storeId", description = "가게의 아이디, path variable 입니다!")
    })
    public ApiResponse<StoreResponseDTO.ReviewPreViewListDTO> getReviewList(@ExistStore @PathVariable(name = "storeId") Long storeId,@RequestParam(name = "page") Integer page){
        Page<Review> reviewList = storeQueryService.getReviewList(storeId,page);
        return ApiResponse.onSuccess(StoreConverter.reviewPreViewListDTO(reviewList));
    }

    @GetMapping("/{storeId}/missions")
    @Operation(summary = "특정 가게의 미션 목록 조회", description = "가게의 미션 목록을 1페이지부터")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "페이지가 1보다 작음", content = @Content(schema = @Schema(implementation = ApiResponse.class)))
    })
    @Parameters({
            @Parameter(name = "storeId", description = "가게 ID "),
            @Parameter(name = "page", description = "1 이상의 정수")
    })
    public ApiResponse<MissionResponseDTO.MissionListDTO> getStoreMissions(
            @PathVariable Long storeId,
            @CheckPage @RequestParam("page") Integer page) {

        Page<Mission> missions = missionQueryService.getMissionsByStoreId(storeId, page - 1);
        return ApiResponse.onSuccess(MissionConverter.toMissionListDTO(missions));
    }
}