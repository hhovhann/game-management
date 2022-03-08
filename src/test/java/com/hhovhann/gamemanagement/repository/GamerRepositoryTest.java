package com.hhovhann.gamemanagement.repository;

import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.spring.api.DBRider;
import com.hhovhann.gamemanagement.entity.Gamer;
import com.hhovhann.gamemanagement.entity.data.Level;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DBRider
@SpringBootTest
class GamerRepositoryTest {

    @Autowired
    private GamerRepository gamerRepository;

    @Test
    @DataSet(cleanBefore = true, value = {"gamer/gamers.yml"})
    @DisplayName("Should properly delete the order created initially")
    public void shouldFindGamersByLevel() {
        assertThat(gamerRepository).isNotNull();
        assertThat(gamerRepository.count()).isEqualTo(3);
        List<Gamer> gamers = gamerRepository.findByLevel(Level.PRO);

        Assertions.assertThat(gamers.size()).isEqualTo(3);
    }
}