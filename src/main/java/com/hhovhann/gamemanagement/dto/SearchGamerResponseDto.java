package com.hhovhann.gamemanagement.dto;

import com.hhovhann.gamemanagement.entity.data.GameLevel;
import com.hhovhann.gamemanagement.entity.data.Geography;
import lombok.Builder;

import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import static javax.persistence.EnumType.STRING;

@Builder
public class SearchGamerResponseDto {
    @NotBlank
    private Long gameId;

    @NotBlank
    private Long gamerId;

    @Enumerated(STRING)
    private GameLevel gameLevel;

    @NotNull
    private Geography geography;
}
