package com.hhovhann.gamemanagement.dto;


import com.hhovhann.gamemanagement.entity.Gamer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class GameResponseDto {

    Long gameId;

    String gameName;

    List<Gamer> gamers;
}
