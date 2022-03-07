package com.hhovhann.gamemanagement.controller;

import com.hhovhann.gamemanagement.dto.LinkedGamerRequestDto;
import com.hhovhann.gamemanagement.dto.LinkedGamerResponseDto;
import com.hhovhann.gamemanagement.dto.SearchGamerRequestDto;
import com.hhovhann.gamemanagement.dto.SearchGamerResponseDto;
import com.hhovhann.gamemanagement.service.GameService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController("api/v1/game")
public class GameController {
    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @ResponseBody
    @PostMapping("/gamers")
    @ApiResponse(description = "API to link gamer to a game")
    public ResponseEntity<LinkedGamerResponseDto> linkToGame(@Valid LinkedGamerRequestDto gamerRequestDto) {
        return ResponseEntity.ok(gameService.linkGamerToGame(gamerRequestDto));
    }

    @ResponseBody
    @DeleteMapping(value = "/gamers", produces = APPLICATION_JSON_VALUE)
    @ApiResponse(description = "API to unlink gamer from a game")
    public ResponseEntity<LinkedGamerResponseDto> unlinkFromGame(@Valid LinkedGamerRequestDto gamerRequestDto) {
        return ResponseEntity.ok(gameService.unLinkGamerFromGame(gamerRequestDto));
    }

    @ResponseBody
    @GetMapping(value = "/gamers", produces = APPLICATION_JSON_VALUE)
    @ApiResponse(description = "API based on level, game and geography for auto-matching gamers.")
    public ResponseEntity<List<SearchGamerResponseDto>> searchGamers(@Valid SearchGamerRequestDto searchGamerRequestDto) {
        return ResponseEntity.ok(gameService.retrieveAllGamers(searchGamerRequestDto));
    }

    @ResponseBody
    @GetMapping(value = "/gamers/{gameId}/{gameLevel}", produces = APPLICATION_JSON_VALUE)
    @ApiResponse(description = "API to get the gamers on a specific level(eg. INVINCIBLE) per game")
    public ResponseEntity<List<SearchGamerResponseDto>> searchGamersByLevel(@PathVariable Long gameId, @PathVariable String gameLevel) {
        return ResponseEntity.ok(gameService.retrieveGamersOnSpecificLevel(gameId, gameLevel));
    }
}
