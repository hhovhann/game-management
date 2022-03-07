package com.hhovhann.gamemanagement.service;

import com.hhovhann.gamemanagement.dto.CreateGamerRequestDto;
import com.hhovhann.gamemanagement.dto.CreateGamerResponseDto;
import com.hhovhann.gamemanagement.dto.SearchGamerRequestDto;
import com.hhovhann.gamemanagement.dto.SearchGamerResponseDto;

public interface GameService {
    CreateGamerResponseDto linkToGame(CreateGamerRequestDto gamerRequestDto);

    CreateGamerResponseDto unLinkFromGame(CreateGamerRequestDto gamerRequestDto);

    SearchGamerResponseDto retrieveGamersOnSpecificLevel(String gameLevel);

    SearchGamerResponseDto retrieveGamersByLevelAndGameAngGeography(SearchGamerRequestDto searchGamerRequestDto);
}
