package com.hhovhann.gamemanagement.dto;

import com.hhovhann.gamemanagement.entity.data.Level;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SearchGamerResponseDto {
    private Long gameId;
    private String gameName;
    private Level level;
    private String country;
    private String city;
}
