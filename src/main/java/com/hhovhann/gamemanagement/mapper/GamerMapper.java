package com.hhovhann.gamemanagement.mapper;

import com.hhovhann.gamemanagement.dto.SearchGamerResponseDto;
import com.hhovhann.gamemanagement.entity.Gamer;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class GamerMapper {

    public SearchGamerResponseDto toGamerResponseDto(Gamer gamer) {
        return SearchGamerResponseDto.builder()
                .gameId(Objects.nonNull(gamer.getGame()) ? gamer.getGame().getId() : null)
                .gameName(Objects.nonNull(gamer.getGame()) ? gamer.getGame().getName() : null)
                .level(gamer.getLevel())
                .country(gamer.getCountry())
                .city(gamer.getCity())
                .build();
    }

    public SearchGamerResponseDto toSearchDto(Gamer gamer) {
        return SearchGamerResponseDto.builder()
                .gameId(Objects.nonNull(gamer.getGame()) ? gamer.getGame().getId() : null)
                .gameName(Objects.nonNull(gamer.getGame()) ? gamer.getGame().getName() : null)
                .level(gamer.getLevel())
                .country(gamer.getCountry())
                .city(gamer.getCity())
                .build();
    }
}
