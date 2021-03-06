package com.hhovhann.gamemanagement.controller;

import com.hhovhann.gamemanagement.dto.GameRequestDto;
import com.hhovhann.gamemanagement.dto.GameResponseDto;
import com.hhovhann.gamemanagement.dto.SearchGamerRequestDto;
import com.hhovhann.gamemanagement.dto.SearchGamerResponseDto;
import com.hhovhann.gamemanagement.service.GameService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Validated
@Tag(name = "Game Endpoints Version 1", description = "Game CRUD and Search API")
@RestController
public class GameController {
    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @ResponseBody
    @PostMapping(value = "api/v1/game/gamers", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<GameResponseDto> linkToGame(@RequestBody @Valid GameRequestDto gamerRequestDto) {
        return ResponseEntity.ok(gameService.linkGamerToGame(gamerRequestDto));
    }

    @ResponseBody
    @DeleteMapping(value = "api/v1/game/gamers", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<GameResponseDto> unlinkFromGame(@RequestBody @Valid GameRequestDto gamerRequestDto) {
        return ResponseEntity.ok(gameService.unLinkGamerFromGame(gamerRequestDto));
    }

    @ResponseBody
    @GetMapping(value = "api/v1/game/gamers", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SearchGamerResponseDto>> searchGamers() {
        return ResponseEntity.ok(gameService.retrieveAllGamers());
    }

    @ResponseBody
    @PostMapping(value = "api/v1/games/gamers", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SearchGamerResponseDto>> searchGamersByLevelAndGameAndGeography(@RequestBody @Valid SearchGamerRequestDto searchGamerRequestDto) {
        return ResponseEntity.ok(gameService.retrieveGamersOnSpecificGameAndSpecificLevelAndGeography(searchGamerRequestDto));
    }

    @ResponseBody
    @GetMapping(value = "api/v1/game/gamers/{gameLevel}/{gameId}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SearchGamerResponseDto>> searchGamersByLevelAndGame(@PathVariable @NotBlank String gameLevel, @PathVariable @NotNull @Positive Long gameId) {
        return ResponseEntity.ok(gameService.retrieveGamersOnSpecificLevelAndSpecificGame(gameLevel, gameId));
    }

    @ResponseBody
    @GetMapping(value = "api/v1/game/gamers/{gameLevel}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SearchGamerResponseDto>> searchGamersByLevel(@PathVariable @NotBlank String gameLevel) {
        return ResponseEntity.ok(gameService.retrieveGamersOnSpecificLevel(gameLevel));
    }
}
