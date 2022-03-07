package com.hhovhann.gamemanagement.dto;


import com.hhovhann.gamemanagement.entity.Gamer;
import com.hhovhann.gamemanagement.entity.data.Level;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Enumerated;
import java.util.List;

import static javax.persistence.EnumType.STRING;

@Data
@Builder
public class GameResponseDto {

    Long gameId;

    Long gamerId;

    String gameName;

    @Enumerated(STRING)
    Level level;

    List<Gamer> gamers;
}
