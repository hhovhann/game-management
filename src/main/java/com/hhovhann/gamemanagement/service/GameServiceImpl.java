package com.hhovhann.gamemanagement.service;

import com.hhovhann.gamemanagement.dto.LinkedGamerRequestDto;
import com.hhovhann.gamemanagement.dto.LinkedGamerResponseDto;
import com.hhovhann.gamemanagement.dto.SearchGamerRequestDto;
import com.hhovhann.gamemanagement.dto.SearchGamerResponseDto;
import com.hhovhann.gamemanagement.entity.Game;
import com.hhovhann.gamemanagement.entity.Gamer;
import com.hhovhann.gamemanagement.entity.data.GameLevel;
import com.hhovhann.gamemanagement.exception.GameNotFoundException;
import com.hhovhann.gamemanagement.mapper.GameMapper;
import com.hhovhann.gamemanagement.mapper.GamerMapper;
import com.hhovhann.gamemanagement.repository.GameRepository;
import com.hhovhann.gamemanagement.repository.GamerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class GameServiceImpl implements GameService {

    private final GameMapper gameMapper;
    private final GamerMapper gamerMapper;
    private final GameRepository gameRepository;
    private final GamerRepository gamerRepository;

    public GameServiceImpl(GameMapper gameMapper, GamerMapper gamerMapper, GameRepository gameRepository, GamerRepository gamerRepository) {
        this.gameMapper = gameMapper;
        this.gamerMapper = gamerMapper;
        this.gameRepository = gameRepository;
        this.gamerRepository = gamerRepository;
    }

    @Override
    public LinkedGamerResponseDto linkGamerToGame(LinkedGamerRequestDto gamerRequestDto) {
        // Find the game or throw game not found exception
        Game game = gameRepository.findById(gamerRequestDto.gameId).orElseThrow(() -> new GameNotFoundException("No game was found with specified Id"));
        // Find the gamer or throw gamer not found exception
        Gamer gamer = gamerRepository.findById(gamerRequestDto.gamerId).orElseThrow(() -> new GameNotFoundException("No gamer was found with specified Id"));
        // Add/Link/Attach gamer to the existing game
        game.addGamer(gamer);
        // Save the game
        Game savedGame = gameRepository.save(game);

        return gameMapper.toLinkedGamerDto(savedGame);
    }

    @Override
    public LinkedGamerResponseDto unLinkGamerFromGame(LinkedGamerRequestDto gamerRequestDto) {
        // 1. Find the game or throw game not found exception
        Game game = gameRepository.findById(gamerRequestDto.gameId).orElseThrow(() -> new GameNotFoundException("No game was found with specified Id"));
        // 2. Find Gamer by id or throw gamer not found exception
        Gamer gamer = gamerRepository.findById(gamerRequestDto.gamerId).orElseThrow(() -> new GameNotFoundException("No gamer was found with specified Id"));
        // 3.  Remove/UnLink/Detach gamer from the existing game
        game.removeGamer(gamer);
        // 4. Save the game
        Game savedGame = gameRepository.save(game);

        return gameMapper.toLinkedGamerDto(savedGame);
    }

    @Override
    public List<SearchGamerResponseDto> retrieveAllGamers(SearchGamerRequestDto searchGamerRequestDto) {
        // Find the game or throw game not found exception
        Game game = gameRepository.findByIdAndGameLevel(searchGamerRequestDto.gameId, searchGamerRequestDto.gameLevel).orElseThrow(() -> new GameNotFoundException("No game was found with specified Id and game level"));
        // Return all gamers with specific game id, game level and geography
        return game.getGamers()
                .stream()
                .filter(gamer -> Objects.equals(gamer.getCountry(), searchGamerRequestDto.country) && Objects.equals(gamer.getCity(), searchGamerRequestDto.city))
                .map(gamer -> gameMapper.toSearchDto(game))
                .collect(Collectors.toList());
    }

    @Override
    public List<SearchGamerResponseDto> retrieveGamersOnSpecificLevel(Long gameId, String gameLevel) {
        // Find the gamer throw games not found exception
        Game game = gameRepository.findByIdAndGameLevel(gameId, GameLevel.valueOf(gameLevel))
                .orElseThrow(() -> new GameNotFoundException("No game was found with specified Id and game level"));
        // Return all gamers with specific game level per game
        return game.getGamers().stream()
                .map(gamerMapper::toSearchDto)
                .collect(Collectors.toList());
    }
}
