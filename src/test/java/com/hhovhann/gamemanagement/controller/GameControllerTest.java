package com.hhovhann.gamemanagement.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.spring.api.DBRider;
import com.hhovhann.gamemanagement.dto.GameRequestDto;
import com.hhovhann.gamemanagement.dto.GameResponseDto;
import com.hhovhann.gamemanagement.dto.GamerDto;
import com.hhovhann.gamemanagement.repository.GameRepository;
import com.hhovhann.gamemanagement.service.GameService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static com.hhovhann.gamemanagement.entity.data.Level.PRO;
import static org.hamcrest.core.Is.is;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@DBRider
@SpringBootTest
@AutoConfigureMockMvc
public class GameControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    GameRepository gameRepository;

    @Autowired
    GameService gameService;

    @Autowired
    private ObjectMapper objectMapper;
    private GameRequestDto gameLinkedRequestDto;
    private GameRequestDto gameUnLinkedRequestDto;
    private GameResponseDto gameLinkedResponseDto;
    private GameResponseDto gameUnlinkedResponseDto;

    @BeforeEach
    public void setup() {
        this.gameLinkedRequestDto = new GameRequestDto(1L, 1L);
        this.gameLinkedResponseDto = new GameResponseDto(1L, "FIFA22", List.of(
                new GamerDto(1L, "Hayk Hovhannisyan", PRO, "Armenia", "Yerevan")
        ));

        this.gameUnLinkedRequestDto = new GameRequestDto(2L, 3L);
        this.gameUnlinkedResponseDto = new GameResponseDto(2L, "TAKKEN7", List.of(
                new GamerDto(1L, "Hayk Hovhannisyan", PRO, "Armenia", "Yerevan"),
                new GamerDto(2L, "Ronaldo", PRO, "Brasil", "Sao Paulo")
        ));
    }

    @Test
    @DataSet(cleanBefore = true, value = {"controller/gamer/gamersWithoutLinkedGames.yml"})
    @DisplayName("Return gamer json data linked to game")
    public void givenGameIdAndGamerId_whenLinkGamerToGame_thenReturnJson() throws Exception {
        String jsonBody = objectMapper.writeValueAsString(this.gameLinkedRequestDto);
        mockMvc
                .perform(
                        post("/api/v1/game/gamers")
                                .content(jsonBody)
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(APPLICATION_JSON))
                .andExpect(jsonPath("$.gameId", is(this.gameLinkedResponseDto.getGameId()), Long.class))
                .andExpect(jsonPath("$.gameName", is(this.gameLinkedResponseDto.getGameName()), String.class))
                .andExpect(jsonPath("$.gamers.size()", is(1)))

                .andExpect(jsonPath("$.gamers.[0].id", is(this.gameLinkedResponseDto.getGamers().get(0).getId()), Long.class))
                .andExpect(jsonPath("$.gamers.[0].name", is(this.gameLinkedResponseDto.getGamers().get(0).getName()), String.class));
    }

    @Test
    @DataSet(cleanBefore = true, value = {"controller/gamer/gamersWithLinkedGames.yml"})
    @DisplayName("Return gamer json data unlinked from game")
    public void givenGameIdAndGamerId_whenUnLinkGamerToGame_thenReturnJsonArray() throws Exception {
        String jsonBody = objectMapper.writeValueAsString(gameUnLinkedRequestDto);

        mockMvc.perform(delete("/api/v1/game/gamers")
                        .contentType(APPLICATION_JSON)
                        .content(jsonBody)
                        .accept(APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(APPLICATION_JSON))
                .andExpect(jsonPath("$.gameId", is(this.gameUnlinkedResponseDto.getGameId()), Long.class))
                .andExpect(jsonPath("$.gameName", is(this.gameUnlinkedResponseDto.getGameName()), String.class))
                .andExpect(jsonPath("$.gamers.size()", is(2)))

                .andExpect(jsonPath("$.gamers.[0].id", is(this.gameUnlinkedResponseDto.getGamers().get(0).getId()), Long.class))
                .andExpect(jsonPath("$.gamers.[0].name", is(this.gameUnlinkedResponseDto.getGamers().get(0).getName()), String.class))

                .andExpect(jsonPath("$.gamers.[1].id", is(this.gameUnlinkedResponseDto.getGamers().get(1).getId()), Long.class))
                .andExpect(jsonPath("$.gamers.[1].name", is(this.gameUnlinkedResponseDto.getGamers().get(1).getName()), String.class));
    }

    @Test
    @DataSet(cleanBefore = true, value = {"controller/gamer/allGamersWithAllGames.yml"})
    @DisplayName("Return all gamers with specific level per game")
    public void givenGameLevel_whenGetAllGamers_thenReturnJsonArray() throws Exception {
        mockMvc.perform(get("/api/v1/game/gamers/PRO"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(APPLICATION_JSON))

                .andExpect(jsonPath("$.[0].gameName", is("FIFA22")))
                .andExpect(jsonPath("$.[0].gameId", is(1L), Long.class));
    }

    @Test
    @DataSet(cleanBefore = true, value = {"controller/gamer/allGamersWithAllGames.yml"})
    @DisplayName("Return all gamers with specific level and specific game")
    public void givenGameLevelAndGameId_whenGetAllGamers_thenReturnJsonArray() throws Exception {
        mockMvc.perform(get("/api/v1/game/gamers/INVINCIBLE/2"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(APPLICATION_JSON))

                .andExpect(jsonPath("$.[0].gameName", is("TAKKEN7")))
                .andExpect(jsonPath("$.[0].gameId", is(2L), Long.class));
    }
}
