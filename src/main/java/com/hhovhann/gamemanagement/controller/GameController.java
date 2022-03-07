package com.hhovhann.gamemanagement.controller;

import com.hhovhann.gamemanagement.dto.CreateGamerRequestDto;
import com.hhovhann.gamemanagement.dto.CreateGamerResponseDto;
import com.hhovhann.gamemanagement.dto.SearchGamerRequestDto;
import com.hhovhann.gamemanagement.dto.SearchGamerResponseDto;
import com.hhovhann.gamemanagement.service.GameService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController("api/v1/game")
public class GameController {
    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping("/gamers")
    public ResponseEntity<CreateGamerResponseDto> linkToGame(@Valid CreateGamerRequestDto gamerRequestDto) {
        // 1. API to link gamer to a game
        return ResponseEntity.ok(gameService.linkToGame(gamerRequestDto));
    }

    @DeleteMapping("/gamers")
    public ResponseEntity<CreateGamerResponseDto> unlinkFromGame(@Valid CreateGamerRequestDto gamerRequestDto) {
        // 2. API to unlink gamer from a game
        return ResponseEntity.ok(gameService.unLinkFromGame(gamerRequestDto));
    }

    @GetMapping("/gamers")
    public ResponseEntity<SearchGamerResponseDto> searchGamers(@Valid SearchGamerRequestDto searchGamerRequestDto) {
        // 3. Search API based on level, game and geography for auto-matching gamers.
        return ResponseEntity.ok(gameService.retrieveGamersByLevelAndGameAngGeography(searchGamerRequestDto));
    }

    @GetMapping("/gamers/{gameLevel}")
    public ResponseEntity<SearchGamerResponseDto> searchGamersByLevel(@Valid @PathVariable String gameLevel) {
        // 4. API to get the gamers on a specific level(eg. INVINCIBLE) per game
        return ResponseEntity.ok(gameService.retrieveGamersOnSpecificLevel(gameLevel));
    }
}
