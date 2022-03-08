package com.hhovhann.gamemanagement.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class GameResponseDto {
    private Long gameId;
    private String gameName;
    private List<GamerDto> gamers;
}
