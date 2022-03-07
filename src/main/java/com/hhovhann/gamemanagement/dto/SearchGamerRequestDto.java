package com.hhovhann.gamemanagement.dto;


import com.hhovhann.gamemanagement.entity.data.GameLevel;
 import org.springframework.validation.annotation.Validated;

import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import static javax.persistence.EnumType.STRING;

@Validated
public class SearchGamerRequestDto {
    @NotBlank
    public Long gameId;

    @Enumerated(STRING)
    public GameLevel gameLevel;

    @NotNull
    public String country;

    @NotNull
    public String city;
}
