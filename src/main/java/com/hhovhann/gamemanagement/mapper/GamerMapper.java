package com.hhovhann.gamemanagement.mapper;

import com.hhovhann.gamemanagement.dto.SearchGamerResponseDto;
import com.hhovhann.gamemanagement.entity.Gamer;
import org.springframework.stereotype.Component;

@Component
public class GamerMapper {

    public SearchGamerResponseDto toSearchDto(Gamer gamer) {
        return SearchGamerResponseDto.builder()
                .gamerId(gamer.getId())
                .gameId(gamer.getGame().getId())
                .country(gamer.getCountry())
                .city(gamer.getCity())
                .build();
    }
}
