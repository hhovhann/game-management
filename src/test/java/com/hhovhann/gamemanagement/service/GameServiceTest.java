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

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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
    private Gamer fifa22Gamer;

    private Game taken7Game;
    private Gamer taken7Gamer;

    private Game mortalCombat11Game;
    private Gamer mortalCombat11Gamer;

    private GameRequestDto gameRequestDto;
    private GameResponseDto gameResponseDto;

    @BeforeEach
    public void setup() {
        this.fifa22Gamer = new Gamer(1L, "Hayk Hovhannisyan", PRO, "Armenia", "Yerevan");
        this.fifa22Game = new Game(1L, "FIFA22", Arrays.asList(this.fifa22Gamer));

        this.taken7Gamer = new Gamer(2L, "Hayk Hovhannisyan", PRO, "Armenia", "Yerevan");
        this.taken7Game = new Game(2L, "TAKKEN7", Arrays.asList(this.taken7Gamer));

        this.mortalCombat11Gamer = new Gamer(2L, "Hayk Hovhannisyan", PRO, "Armenia", "Yerevan");
        this.mortalCombat11Game = new Game(3L, "MORTAL COMBAT 11", Arrays.asList(new Gamer(2L, "Hayk Hovhannisyan", PRO, "Armenia", "Yerevan")));

        this.gameRequestDto = new GameRequestDto(1L, 1L);
        this.gameResponseDto = new GameResponseDto(1L, 1L, "FIFA22", PRO, Arrays.asList(this.fifa22Gamer));
    }

    @Test
    @DisplayName("Return game with linked gamers")
    public void givenGameIdAndGamerId_whenLinkGamerToGame_thenReturnGamers() throws Exception {
        // given
        when(gameRepository.findById(gameRequestDto.getGameId())).thenReturn(Optional.of(this.fifa22Game));
        when(gamerRepository.findById(gameRequestDto.getGamerId())).thenReturn(Optional.of(this.fifa22Gamer));

        // when
        GameResponseDto gameResponseDto = gameService.linkGamerToGame(this.gameRequestDto);

        // then
        Assertions.assertThat(gameResponseDto.getGameId()).isEqualTo(1L);
        Assertions.assertThat(gameResponseDto.getGamerId()).isEqualTo(1L);
        Assertions.assertThat(gameResponseDto.getLevel()).isEqualTo(PRO);

    }

    @Test
    @DisplayName("Return campaign group when campaign group are provided")
    public void givenGameIdAndGamerId_whenUnLinkGamerToGame_thenReturnGamers() throws Exception {
        // given
        when(gameRepository.findById(gameRequestDto.getGameId())).thenReturn(Optional.of(this.fifa22Game));
        when(gamerRepository.findById(gameRequestDto.getGamerId())).thenReturn(Optional.of(this.fifa22Gamer));
        when(gameRepository.save(this.fifa22Game)).thenReturn(this.fifa22Game);

        // when
        GameResponseDto gameResponseDto = gameService.unLinkGamerFromGame(this.gameRequestDto);

        // then
        Assertions.assertThat(gameResponseDto.getGameId()).isEqualTo(1L);
        Assertions.assertThat(gameResponseDto.getGamerId()).isEqualTo(1L);
        Assertions.assertThat(gameResponseDto.getLevel()).isEqualTo(PRO);
    }


    @Test
    @DisplayName("Return all gamers")
    public void whenRetrieveAllGamers_thenReturnAllGamers() throws Exception {
        // given
        when(gameRepository.findById(gameRequestDto.getGameId())).thenReturn(Optional.of(this.fifa22Game));
        when(gamerRepository.findById(gameRequestDto.getGamerId())).thenReturn(Optional.of(this.fifa22Gamer));
        when(gameRepository.save(this.fifa22Game)).thenReturn(this.fifa22Game);

        // when
        List<SearchGamerResponseDto> searchGamerResponseDtos = gameService.retrieveAllGamers();

        // then
        Assertions.assertThat(searchGamerResponseDtos.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("Return all gamers by specific level")
    public void whenRetrieveGamersBySpecificLevel_thenReturnAllGamersBySpecificLevel() throws Exception {
        // given
        when(gameRepository.findById(gameRequestDto.getGameId())).thenReturn(Optional.of(this.fifa22Game));
        when(gamerRepository.findById(gameRequestDto.getGamerId())).thenReturn(Optional.of(this.fifa22Gamer));
        when(gameRepository.save(this.fifa22Game)).thenReturn(this.fifa22Game);

        // when
        List<SearchGamerResponseDto> searchGamerResponseDtos = gameService.retrieveGamersOnSpecificLevel(String.valueOf(N00B));

        // then
        Assertions.assertThat(searchGamerResponseDtos.size()).isEqualTo(0);
    }
}