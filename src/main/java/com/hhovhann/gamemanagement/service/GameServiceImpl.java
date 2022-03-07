package com.hhovhann.gamemanagement.service;

import com.hhovhann.gamemanagement.dto.CreateGamerRequestDto;
import com.hhovhann.gamemanagement.dto.CreateGamerResponseDto;
import com.hhovhann.gamemanagement.dto.SearchGamerRequestDto;
import com.hhovhann.gamemanagement.dto.SearchGamerResponseDto;
import com.hhovhann.gamemanagement.repository.GameRepository;
import org.springframework.stereotype.Service;

@Service
public class GameServiceImpl implements GameService {
    private final GameRepository gameRepository;

    public GameServiceImpl(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Override
    public CreateGamerResponseDto linkToGame(CreateGamerRequestDto gamerRequestDto) {
        // TODO attach gamer from game business logic here
        return null;
    }

    @Override
    public CreateGamerResponseDto unLinkFromGame(CreateGamerRequestDto gamerRequestDto) {
        // TODO detach gamer from game business logic here
        return null;
    }

    @Override
    public SearchGamerResponseDto retrieveGamersOnSpecificLevel(String gameLevel) {
        // TODO API to get the gamers on a specific level(eg. INVINCIBLE) per game business logic here
        return null;
    }

    @Override
    public SearchGamerResponseDto retrieveGamersByLevelAndGameAngGeography(SearchGamerRequestDto searchGamerRequestDto) {
        // TODO API to get the gamers on a specific level(eg. INVINCIBLE) per game business logic here
        return null;
    }
}
