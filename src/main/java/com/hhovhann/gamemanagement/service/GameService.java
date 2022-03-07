package com.hhovhann.gamemanagement.service;

import com.hhovhann.gamemanagement.dto.LinkedGamerRequestDto;
import com.hhovhann.gamemanagement.dto.LinkedGamerResponseDto;
import com.hhovhann.gamemanagement.dto.SearchGamerRequestDto;
import com.hhovhann.gamemanagement.dto.SearchGamerResponseDto;

import java.util.List;

public interface GameService {
    /***
     * API to link gamer to a game"
     */
    LinkedGamerResponseDto linkGamerToGame(LinkedGamerRequestDto gamerRequestDto);

    /***
     * API to unlink gamer from game"
     */
    LinkedGamerResponseDto unLinkGamerFromGame(LinkedGamerRequestDto gamerRequestDto);

    /***
     * Search API based on level, game and geography for auto-matching gamers.
     */
    List<SearchGamerResponseDto> retrieveAllGamers(SearchGamerRequestDto searchGamerRequestDto);

    /***
     * API to get the gamers on a specific level(eg. INVINCIBLE) per game business logic here
     */
    List<SearchGamerResponseDto> retrieveGamersOnSpecificLevel(Long gameId, String gameLevel);
}
