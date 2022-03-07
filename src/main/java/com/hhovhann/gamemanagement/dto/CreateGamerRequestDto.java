package com.hhovhann.gamemanagement.dto;


import com.hhovhann.gamemanagement.entity.data.GameLevel;
import com.hhovhann.gamemanagement.entity.data.Geography;
import org.springframework.validation.annotation.Validated;

import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import static javax.persistence.EnumType.STRING;

@Validated
public class CreateGamerRequestDto {
    @NotBlank
    private Long id;

    @Enumerated(STRING)
    private GameLevel gameLevel;

    @NotNull
    private Geography geography;
}
