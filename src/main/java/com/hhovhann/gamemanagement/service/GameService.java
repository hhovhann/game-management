package com.hhovhann.gamemanagement.service;

import com.hhovhann.gamemanagement.dto.GameRequestDto;
import com.hhovhann.gamemanagement.dto.GameResponseDto;
import com.hhovhann.gamemanagement.dto.SearchGamerRequestDto;
import com.hhovhann.gamemanagement.dto.SearchGamerResponseDto;

import java.util.List;

public interface GameService {
    /***
     * API to link gamer to a game
     */
    GameResponseDto linkGamerToGame(GameRequestDto gamerRequestDto);

    /***
     * CRUD API to unlink gamer from game
     */
    GameResponseDto unLinkGamerFromGame(GameRequestDto gamerRequestDto);

    /***
     * Search API: retrieve all gamers.
     */
    List<SearchGamerResponseDto> retrieveAllGamers();

    /***
     * Search API: retrieve all gamers on a specific level(ex. INVINCIBLE)
     */
    List<SearchGamerResponseDto> retrieveGamersOnSpecificLevel(String gameLevel);

    /***
     * Search API: retrieve all gamers on a specific level(ex. INVINCIBLE) and specific game (ex. 1L - FIFA22)
     */
    List<SearchGamerResponseDto> retrieveGamersOnSpecificLevelAndSpecificGame(String gameLevel, Long gameId);

    /***
     * Search API: retrieve all gamers on a specific level(ex. INVINCIBLE) and specific game (ex. 1L - FIFA22) and specific geography (ex. country: Armenia, city: Yerevan)
     */
    List<SearchGamerResponseDto> retrieveGamersOnSpecificGameAndSpecificLevelAndGeography(SearchGamerRequestDto searchGamerRequestDto);
}
