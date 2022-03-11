package com.hhovhann.gamemanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@AllArgsConstructor
public class SearchGamerRequestDto {
    @NotNull(message = "Game Id cannot be null")
    @Positive(message = "Game Id should be positive")
    public Long gameId;

    @NotBlank(message = "Gamer level cannot be empty or null")
    public String level;

    @NotBlank(message = "Gamer country cannot be empty or null")
    public String country;

    @NotBlank(message = "Gamer city cannot be empty or null")
    public String city;
}
