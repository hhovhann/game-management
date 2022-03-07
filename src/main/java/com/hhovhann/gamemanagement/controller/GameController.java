package com.hhovhann.gamemanagement.controller;

import com.hhovhann.gamemanagement.dto.GameRequestDto;
import com.hhovhann.gamemanagement.dto.GameResponseDto;
import com.hhovhann.gamemanagement.dto.SearchGamerResponseDto;
import com.hhovhann.gamemanagement.service.GameService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
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
    @PostMapping(value = "/gamers", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<GameResponseDto> linkToGame(@Valid GameRequestDto gamerRequestDto) {
        return ResponseEntity.ok(gameService.linkGamerToGame(gamerRequestDto));
    }

    @ResponseBody
    @DeleteMapping(value = "/gamers", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<GameResponseDto> unlinkFromGame(@Valid GameRequestDto gamerRequestDto) {
        return ResponseEntity.ok(gameService.unLinkGamerFromGame(gamerRequestDto));
    }

    @ResponseBody
    @GetMapping(value = "/gamers", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SearchGamerResponseDto>> searchGamers() {
        return ResponseEntity.ok(gameService.retrieveAllGamers());
    }

    @ResponseBody
    @GetMapping(value = "/gamers/{gameLevel}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SearchGamerResponseDto>> searchGamersByLevel(@PathVariable @NotBlank String gameLevel) {
        return ResponseEntity.ok(gameService.retrieveGamersOnSpecificLevel(gameLevel));
    }
}
