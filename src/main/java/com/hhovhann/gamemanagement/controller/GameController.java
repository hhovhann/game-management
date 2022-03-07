package com.hhovhann.gamemanagement.controller;

import com.hhovhann.gamemanagement.dto.LinkedGamerRequestDto;
import com.hhovhann.gamemanagement.dto.LinkedGamerResponseDto;
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
@Tag(name = "Game endpoints")
@RestController("api/v1/game")
public class GameController {
    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @ResponseBody
    @PostMapping(value = "/gamers", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<LinkedGamerResponseDto> linkToGame(@Valid LinkedGamerRequestDto gamerRequestDto) {
        return ResponseEntity.ok(gameService.linkGamerToGame(gamerRequestDto));
    }

    @ResponseBody
    @DeleteMapping(value = "/gamers", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<LinkedGamerResponseDto> unlinkFromGame(@Valid LinkedGamerRequestDto gamerRequestDto) {
        return ResponseEntity.ok(gameService.unLinkGamerFromGame(gamerRequestDto));
    }

    @ResponseBody
    @GetMapping(value = "/gamers", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SearchGamerResponseDto>> searchGamers(@Valid SearchGamerRequestDto searchGamerRequestDto) {
        return ResponseEntity.ok(gameService.retrieveAllGamers(searchGamerRequestDto));
    }

    @ResponseBody
    @GetMapping(value = "/gamers/{gameId}/{gameLevel}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SearchGamerResponseDto>> searchGamersByLevel(@PathVariable @NotNull @Positive Long gameId, @PathVariable @NotBlank String gameLevel) {
        return ResponseEntity.ok(gameService.retrieveGamersOnSpecificLevel(gameId, gameLevel));
    }
}
