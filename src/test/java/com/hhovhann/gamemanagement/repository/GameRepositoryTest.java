package com.hhovhann.gamemanagement.repository;

import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.spring.api.DBRider;
import com.hhovhann.gamemanagement.entity.Game;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@DBRider
@SpringBootTest
class GameRepositoryTest {

    @Autowired
    private GameRepository gameRepository;

    @Test
    @DataSet(cleanBefore = true, transactional = true, value = {"game/games.yml"})
    @DisplayName("Should properly create the game and find gamer")
    public void shouldCreateGame() {
        assertThat(gameRepository).isNotNull();
        assertThat(gameRepository.count()).isEqualTo(3);

        Game game = gameRepository.findById(1L).get();
        assertThat(game.getId()).isEqualTo(1L);
        assertThat(game.getName()).isEqualTo("FIFA22");
        assertThat(game.getGamers().size()).isEqualTo(1);
    }
}