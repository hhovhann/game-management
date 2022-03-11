package com.hhovhann.gamemanagement.service;

import com.hhovhann.gamemanagement.dto.GameRequestDto;
import com.hhovhann.gamemanagement.dto.GameResponseDto;
import com.hhovhann.gamemanagement.dto.SearchGamerRequestDto;
import com.hhovhann.gamemanagement.dto.SearchGamerResponseDto;
import com.hhovhann.gamemanagement.entity.Game;
import com.hhovhann.gamemanagement.entity.Gamer;
import com.hhovhann.gamemanagement.entity.data.Level;
import com.hhovhann.gamemanagement.exception.GameNotFoundException;
import com.hhovhann.gamemanagement.mapper.GameMapper;
import com.hhovhann.gamemanagement.mapper.GamerMapper;
import com.hhovhann.gamemanagement.repository.GameRepository;
import com.hhovhann.gamemanagement.repository.GamerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
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
    public GameResponseDto linkGamerToGame(GameRequestDto gamerRequestDto) {
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
    public GameResponseDto unLinkGamerFromGame(GameRequestDto gamerRequestDto) {
        // Find the game or throw game not found exception
        Game game = gameRepository.findById(gamerRequestDto.gameId).orElseThrow(() -> new GameNotFoundException("No game was found with specified Id"));
        // Find Gamer by id or throw gamer not found exception
        Gamer gamer = gamerRepository.findById(gamerRequestDto.gamerId).orElseThrow(() -> new GameNotFoundException("No gamer was found with specified Id"));
        // Remove/UnLink/Detach gamer from the existing game
        game.removeGamer(gamer);
        // Save the game
        Game savedGame = gameRepository.save(game);

        return gameMapper.toLinkedGamerDto(savedGame);
    }

    @Override
    public List<SearchGamerResponseDto> retrieveAllGamers() {
        // Find the game or throw game not found exception
        List<Gamer> gamers = gamerRepository.findAll();
        // Return all gamers with specific game id, game level and geography
        return gamers
                .stream()
                .map(gamerMapper::toSearchDto)
                .collect(Collectors.toList());
    }


    @Override
    public List<SearchGamerResponseDto> retrieveGamersOnSpecificGameAndSpecificLevelAndGeography(SearchGamerRequestDto searchGamerRequestDto) {
        // Find the game or throw game not found exception
        List<Gamer> gamers = gamerRepository.findByGame_idAndLevelAndCountryAndCity(searchGamerRequestDto.getGameId(), Level.valueOf(searchGamerRequestDto.getLevel()), searchGamerRequestDto.getCountry(), searchGamerRequestDto.getCity());
        // Return all gamers with specific game id, game level and geography
        return gamers
                .stream()
                .map(gamerMapper::toSearchDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<SearchGamerResponseDto> retrieveGamersOnSpecificLevelAndSpecificGame(String gameLevel, Long gameId) {
        // Find the gamer throw games not found exception
        List<Gamer> gamers = gamerRepository.findByLevelAndGame_id(Level.valueOf(gameLevel), gameId);
        // Return all gamers with specific game level per game
        return gamers.stream()
                .map(gamerMapper::toSearchDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<SearchGamerResponseDto> retrieveGamersOnSpecificLevel(String gameLevel) {
        // Find the gamer throw games not found exception
        List<Gamer> gamers = gamerRepository.findByLevel(Level.valueOf(gameLevel));
        // Return all gamers with specific game level per game
        return gamers.stream()
                .map(gamerMapper::toSearchDto)
                .collect(Collectors.toList());
    }
}
