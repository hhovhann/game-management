package com.hhovhann.gamemanagement.dto;


import com.hhovhann.gamemanagement.entity.data.GameLevel;

import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import static javax.persistence.EnumType.STRING;

public class SearchGamerRequestDto {

    @NotNull
    @Positive(message = "Game Id should be positive")
    public Long gameId;

    @NotBlank(message = "Game Level should be provided")
    @Enumerated(STRING)
    public GameLevel gameLevel;

    @NotBlank(message = "Country should be provided")
    public String country;

    @NotBlank(message = "City should be provided")
    public String city;

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public GameLevel getGameLevel() {
        return gameLevel;
    }

    public void setGameLevel(GameLevel gameLevel) {
        this.gameLevel = gameLevel;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

}
