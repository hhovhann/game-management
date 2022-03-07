package com.hhovhann.gamemanagement.dto;

import javax.validation.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;

@Validated
public class LinkedGamerRequestDto {
    @NotBlank
    public Long gameId;

    @NotBlank
    public Long gamerId;
}
