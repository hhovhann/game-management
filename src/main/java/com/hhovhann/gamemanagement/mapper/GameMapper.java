package com.hhovhann.gamemanagement.mapper;

import com.hhovhann.gamemanagement.dto.GameResponseDto;
import com.hhovhann.gamemanagement.dto.GamerDto;
import com.hhovhann.gamemanagement.entity.Game;
import com.hhovhann.gamemanagement.entity.Gamer;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class GameMapper {

    public GameResponseDto toLinkedGamerDto(Game game) {
        return GameResponseDto
                .builder()
                .gameId(game.getId())
                .gameName(game.getName())
                .gamers(gamerDtos(game.getGamers()))
                .build();
    }

    public List<GamerDto> gamerDtos(List<Gamer> gamers) {
        return gamers
                .stream()
                .map(gamer -> new GamerDto(gamer.getId(),
                        gamer.getName(),
                        gamer.getLevel(),
                        gamer.getCountry(),
                        gamer.getCity()
                ))
                .collect(Collectors.toList());
    }
}
