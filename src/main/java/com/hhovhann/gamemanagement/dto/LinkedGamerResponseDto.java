package com.hhovhann.gamemanagement.dto;


import com.hhovhann.gamemanagement.entity.Gamer;
import com.hhovhann.gamemanagement.entity.data.GameLevel;
import lombok.Builder;

import javax.persistence.Enumerated;
import java.util.List;

import static javax.persistence.EnumType.STRING;

@Builder
public class LinkedGamerResponseDto {

    Long gameId;

    Long gamerId;

    String gameName;

    @Enumerated(STRING)
    GameLevel gameLevel;

    List<Gamer> gamers;
}