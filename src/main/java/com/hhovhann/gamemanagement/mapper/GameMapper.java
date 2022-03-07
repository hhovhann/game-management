package com.hhovhann.gamemanagement.mapper;

import com.hhovhann.gamemanagement.dto.LinkedGamerResponseDto;
import com.hhovhann.gamemanagement.dto.SearchGamerResponseDto;
import com.hhovhann.gamemanagement.entity.Game;
import org.springframework.stereotype.Component;

@Component
public class GameMapper {

    public SearchGamerResponseDto toSearchDto(Game game) {
        // todo add mapping to game entity
        return null;
    }

    public LinkedGamerResponseDto toLinkedGamerDto(Game game) {
        return LinkedGamerResponseDto
                .builder()
                .gameId(game.getId())
                .gameLevel(game.getGameLevel())
                .gamers(game.getGamers())
                .build();
    }
}
