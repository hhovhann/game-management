package com.hhovhann.gamemanagement.service;

import com.hhovhann.gamemanagement.dto.GameRequestDto;
import com.hhovhann.gamemanagement.dto.GameResponseDto;
import com.hhovhann.gamemanagement.dto.SearchGamerRequestDto;
import com.hhovhann.gamemanagement.dto.SearchGamerResponseDto;

import java.util.List;

public interface GameService {
    /***
     * API to link gamer to a game"
     */
    GameResponseDto linkGamerToGame(GameRequestDto gamerRequestDto);

    /***
     * API to unlink gamer from game"
     */
    GameResponseDto unLinkGamerFromGame(GameRequestDto gamerRequestDto);

    /***
     * Search API based on level, game and geography for auto-matching gamers.
     */
    List<SearchGamerResponseDto> retrieveAllGamers();

    /***
     * API to get the gamers on a specific level(ex. INVINCIBLE) per game business logic here
     */
    List<SearchGamerResponseDto> retrieveGamersOnSpecificLevel(String gameLevel);

    /***
     * API to get the gamers on a specific level(ex. INVINCIBLE) and specific game(ex. 1L - FIFA22)
     */
    List<SearchGamerResponseDto> retrieveGamersOnSpecificLevelAndSpecificGame(String gameLevel, Long gameId);

    /***
     * API to get the gamers on a specific level(ex. INVINCIBLE) and specific game(ex. 1L - FIFA22)
     */
    List<SearchGamerResponseDto> retrieveGamersOnSpecificGameAndSpecificLevelAndGeography(SearchGamerRequestDto searchGamerRequestDto);
}
