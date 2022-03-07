package com.hhovhann.gamemanagement.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class LinkedGamerRequestDto {
    @NotNull
    @Positive(message = "Game Id should be positive")
    public Long gameId;


    @NotNull
    @Positive(message = "Gamer Id should be positive")
    public Long gamerId;

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public Long getGamerId() {
        return gamerId;
    }

    public void setGamerId(Long gamerId) {
        this.gamerId = gamerId;
    }
}
