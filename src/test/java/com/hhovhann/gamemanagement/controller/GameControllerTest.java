package com.hhovhann.gamemanagement.controller;

import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.spring.api.DBRider;
import com.hhovhann.gamemanagement.dto.GameRequestDto;
import com.hhovhann.gamemanagement.dto.GameResponseDto;
import com.hhovhann.gamemanagement.entity.Game;
import com.hhovhann.gamemanagement.entity.Gamer;
import com.hhovhann.gamemanagement.entity.data.Level;
import com.hhovhann.gamemanagement.repository.GameRepository;
import com.hhovhann.gamemanagement.service.GameService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@DBRider
@SpringBootTest
@AutoConfigureMockMvc
public class GameControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    GameRepository gameRepository;

    @MockBean
    GameService gameService;

    private Game fifa22Game;
    private Game taken7Game;
    private Game mortalCombat11Game;

    private GameRequestDto gameRequestDto;
    private GameResponseDto gameResponseDto;

    @BeforeEach
    public void setup() {
        this.fifa22Game = new Game(1L, "FIFA22", Collections.singletonList(new Gamer(1L, "Hayk Hovhannisyan 1", Level.PRO, "Armenia", "Yerevan")));
        this.taken7Game = new Game(2L, "TAKKEN7", Collections.singletonList(new Gamer(2L, "Hayk Hovhannisyan 1", Level.PRO, "Armenia", "Yerevan")));
        this.mortalCombat11Game = new Game(3L, "MORTAL COMBAT 11", Collections.singletonList(new Gamer(2L, "Hayk Hovhannisyan 1", Level.PRO, "Armenia", "Yerevan")));

        this.gameRequestDto = new GameRequestDto(1L, 1L);
        this.gameResponseDto = new GameResponseDto(1L, 1L, "FIFA22", Level.PRO, Collections.singletonList(new Gamer(1L, "Hayk Hovhannisyan 1", Level.PRO, "Armenia", "Yerevan")));
    }

    @Test
    @DisplayName("Return campaign group when campaign group are provided")
    public void givenGameIdAndGamerId_whenLinkGamerToGame_thenReturnJsonArray() throws Exception {
        mockMvc.perform(post("/api/v1/game/gamers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"gameId\": 1,\"gamerId\": 1}")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.[0].name", is(this.fifa22Game.getName())))
                .andExpect(jsonPath("$.[0].id", is(this.fifa22Game.getId()), Long.class));
    }

    @Test
    @DisplayName("Return campaign group when campaign group are provided")
    public void givenGameIdAndGamerId_whenUnLinkGamerToGame_thenReturnJsonArray() throws Exception {
        mockMvc.perform(delete("/api/v1/game/gamers"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.[0].name", is(this.fifa22Game.getName())))
                .andExpect(jsonPath("$.[0].id", is(this.fifa22Game.getId()), Long.class));
    }

    @Test
    @DataSet(cleanBefore = true, value = {"gamer/gamers.yml"})
    @DisplayName("Return not found when no campaign groups are not provided")
    public void whenGetRequest_thenReturnAllGamers() throws Exception {
        given(gameService.retrieveAllGamers()).willReturn(Collections.emptyList());

        mockMvc.perform(get("/api/v1/game/gamers"))
                .andExpect(status().isOk());
    }

    @Test
    @DataSet(cleanBefore = true, value = {"gamer/gamers.yml"})
    @DisplayName("Return campaign group when campaign group are provided")
    public void givenGameLevel_whenGetAllGamers_thenReturnJsonArray() throws Exception {
        mockMvc.perform(get("/api/v1/game/gamers/PRO"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.[0].name", is(this.fifa22Game.getName())))
                .andExpect(jsonPath("$.[0].id", is(this.fifa22Game.getId()), Long.class));
    }
}