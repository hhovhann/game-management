package com.hhovhann.gamemanagement.dto;


import com.hhovhann.gamemanagement.entity.data.GameLevel;
import com.hhovhann.gamemanagement.entity.data.Geography;

import javax.persistence.Enumerated;

import static javax.persistence.EnumType.STRING;

public class CreateGamerResponseDto {

    private Long id;

    private String name;

    private String email;

    @Enumerated(STRING)
    private GameLevel gameLevel;

    private Geography geography;
}
