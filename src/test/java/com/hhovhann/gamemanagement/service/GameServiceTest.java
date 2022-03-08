package com.hhovhann.gamemanagement.service;

import com.hhovhann.gamemanagement.dto.GameRequestDto;
import com.hhovhann.gamemanagement.dto.GameResponseDto;
import com.hhovhann.gamemanagement.dto.SearchGamerResponseDto;
import com.hhovhann.gamemanagement.entity.Game;
import com.hhovhann.gamemanagement.entity.Gamer;
import com.hhovhann.gamemanagement.repository.GameRepository;
import com.hhovhann.gamemanagement.repository.GamerRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.*;

import static com.hhovhann.gamemanagement.entity.data.Level.N00B;
import static com.hhovhann.gamemanagement.entity.data.Level.PRO;
import static org.mockito.Mockito.when;

@SpringBootTest
public class GameServiceTest {

    @Autowired
    GameService gameService;

    @MockBean
    GameRepository gameRepository;

    @MockBean
    GamerRepository gamerRepository;

    private Game fifa22Game;
    private Gamer fifa22FirstGamer;
    private Gamer fifa22SecondGamer;

    private Game taken7Game;
    private Gamer taken7FirstGamer;
    private Gamer taken7SecondGamer;

    private Game mortalCombat11Game;
    private Gamer mortalCombat11FirstGamer;
    private Gamer mortalCombat11SecondGamer;

    private GameRequestDto gameRequestDto;
    private GameResponseDto gameResponseDto;

    @BeforeEach
    public void setup() {
        // Fifa22 game and gamers
        this.fifa22FirstGamer = new Gamer(1L, "Hayk Hovhannisyan 1", PRO, "Armenia", "Yerevan");
        this.fifa22SecondGamer = new Gamer(2L, "Hayk Hovhannisyan 2", PRO, "Armenia", "Yerevan");
        this.fifa22Game = new Game(1L, "FIFA22", new ArrayList<>() {{
            add(fifa22SecondGamer);
        }});

        // Takken7 game and gamers
        this.taken7FirstGamer = new Gamer(3L, "Hayk Hovhannisyan 3", PRO, "Armenia", "Yerevan");
        this.taken7SecondGamer = new Gamer(4L, "Hayk Hovhannisyan 4", PRO, "Armenia", "Yerevan");
        this.taken7Game = new Game(2L, "TAKKEN7", new ArrayList<>() {{
            add(taken7FirstGamer);
            add(taken7SecondGamer);
        }});

        // MortalCombat11 game and gamers
        this.mortalCombat11FirstGamer = new Gamer(5L, "Hayk Hovhannisyan 5", N00B, "Armenia", "Yerevan");
        this.mortalCombat11SecondGamer = new Gamer(6L, "Hayk Hovhannisyan 6", N00B, "Armenia", "Yerevan");
        this.mortalCombat11Game = new Game(3L, "MORTAL COMBAT 11", new ArrayList<>() {{
            add(mortalCombat11FirstGamer);
            add(mortalCombat11SecondGamer);
        }});

        this.gameRequestDto = new GameRequestDto(1L, 1L);
        this.gameResponseDto = new GameResponseDto(1L, fifa22Game.getName(), Arrays.asList(this.fifa22FirstGamer));
    }

    @Test
    @DisplayName("Return game with linked gamers")
    public void givenGameIdAndGamerId_whenLinkGamerToGame_thenReturnGamers() throws Exception {
        // given
        when(gameRepository.findById(gameRequestDto.getGameId())).thenReturn(Optional.of(this.fifa22Game));
        when(gamerRepository.findById(gameRequestDto.getGamerId())).thenReturn(Optional.of(this.fifa22FirstGamer));
        when(gameRepository.save(this.fifa22Game)).thenReturn(this.fifa22Game);

        // when
        GameResponseDto gameResponseDto = gameService.linkGamerToGame(this.gameRequestDto);

        // then
        Assertions.assertThat(gameResponseDto.getGameId()).isEqualTo(1L);
        Assertions.assertThat(gameResponseDto.getGamers().size()).isEqualTo(2);

    }

    @Test
    @DisplayName("Return campaign group when campaign group are provided")
    public void givenGameIdAndGamerId_whenUnLinkGamerToGame_thenReturnGamers() throws Exception {
        // given
        when(gameRepository.findById(gameRequestDto.getGameId())).thenReturn(Optional.of(this.taken7Game));
        when(gamerRepository.findById(gameRequestDto.getGamerId())).thenReturn(Optional.of(this.taken7FirstGamer));

        when(gameRepository.save(this.taken7Game)).thenReturn(this.taken7Game);

        // when
        GameResponseDto gameResponseDto = gameService.unLinkGamerFromGame(this.gameRequestDto);

        // then
        Assertions.assertThat(gameResponseDto.getGameId()).isEqualTo(2L);
        Assertions.assertThat(gameResponseDto.getGamers().size()).isEqualTo(1);
    }


    @Test
    @DisplayName("Return all gamers")
    public void whenRetrieveAllGamers_thenReturnAllGamers() throws Exception {
        // given
        when(gamerRepository.findAll()).thenReturn(List.of(this.fifa22FirstGamer, this.fifa22SecondGamer, this.taken7FirstGamer, this.taken7SecondGamer, this.mortalCombat11FirstGamer, this.mortalCombat11SecondGamer));

        // when
        List<SearchGamerResponseDto> searchGamerResponseDtos = gameService.retrieveAllGamers();

        // then
        Assertions.assertThat(searchGamerResponseDtos.size()).isEqualTo(6);
    }

    @Test
    @DisplayName("Return all gamers by specific level")
    public void whenRetrieveGamersBySpecificLevel_thenReturnAllGamersBySpecificLevel() throws Exception {
        // given
        when(gamerRepository.findByLevel(N00B)).thenReturn(List.of(this.mortalCombat11FirstGamer, this.mortalCombat11SecondGamer));

        // when
        List<SearchGamerResponseDto> searchGamerResponseDtos = gameService.retrieveGamersOnSpecificLevel(String.valueOf(N00B));

        // then
        Assertions.assertThat(searchGamerResponseDtos.size()).isEqualTo(2);
    }
}