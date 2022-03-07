package com.hhovhann.gamemanagement.mapper;

import com.hhovhann.gamemanagement.dto.GameResponseDto;
import com.hhovhann.gamemanagement.entity.Game;
import org.springframework.stereotype.Component;

@Component
public class GameMapper {

    public GameResponseDto toLinkedGamerDto(Game game) {
        return GameResponseDto
                .builder()
                .gameId(game.getId())
                .gameName(game.getName())
                .gamers(game.getGamers())
                .build();
    }
}
