package com.hhovhann.gamemanagement.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
public class GameRequestDto {
    @NotNull
    @Positive(message = "Game Id should be positive")
    public Long gameId;


    @NotNull
    @Positive(message = "Gamer Id should be positive")
    public Long gamerId;

}
