package com.hhovhann.gamemanagement.repository;

import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.core.api.dataset.ExpectedDataSet;
import com.github.database.rider.junit5.api.DBRider;
import com.hhovhann.gamemanagement.entity.Game;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@DBRider
@SpringBootTest
public class GameRepositoryTest {

    @Autowired
    private GameRepository gameRepository;

    @Test
    @DataSet(cleanBefore = true, transactional = true)
    @ExpectedDataSet("game/game.yml")
    @DisplayName("Should properly create the game")
    public void shouldCreateGame() {
        assertThat(gameRepository).isNotNull();
        assertThat(gameRepository.count()).isEqualTo(0);

        Game gameEntity = new Game();
        gameEntity.setName("FIFA 22");
        gameRepository.save(gameEntity);

        assertThat(gameRepository.count()).isEqualTo(1); //assertion is made by @ExpectedDataset
    }
}