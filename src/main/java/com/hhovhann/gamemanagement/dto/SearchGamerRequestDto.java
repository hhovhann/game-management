package com.hhovhann.gamemanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@AllArgsConstructor
public class SearchGamerRequestDto {
    @NotNull(message = "Game Id cannot be null")
    @Positive(message = "Game Id should be positive")
    public Long gameId;

    @NotNull(message = "Gamer level cannot be null")
    public String level;

    @NotNull(message = "Gamer country cannot be null")
    public String country;

    @NotNull(message = "Gamer city cannot be null")
    public String city;
}
