package com.hhovhann.gamemanagement.dto;

import com.hhovhann.gamemanagement.entity.data.GameLevel;
import lombok.Builder;

import javax.persistence.Enumerated;

import static javax.persistence.EnumType.STRING;

@Builder
public class SearchGamerResponseDto {

    private Long gameId;

    private Long gamerId;

    @Enumerated(STRING)
    private GameLevel gameLevel;

    private String country;

    private String city;
}
