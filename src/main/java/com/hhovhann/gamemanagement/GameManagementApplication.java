package com.hhovhann.gamemanagement;

import com.hhovhann.gamemanagement.entity.Game;
import com.hhovhann.gamemanagement.entity.Gamer;
import com.hhovhann.gamemanagement.entity.data.GameLevel;
import com.hhovhann.gamemanagement.repository.GameRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@Slf4j
@SpringBootApplication
public class GameManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(GameManagementApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadAllEntities(GameRepository repository) {
        return args -> {
            // Fifa 22 game players
            var fifa22Gamers = List.of(
                    new Gamer(1L, "Hayk Hovhannisyan 1", "haik.hovhanisyan1@gmail.com", "Armenia", "Yerevan"),
                    new Gamer(2L, "Hayk Hovhannisyan 2", "haik.hovhanisyan2@gmail.com", "Armenia", "Yerevan"),
                    new Gamer(3L, "Hayk Hovhannisyan 3", "haik.hovhanisyan3@gmail.com", "Armenia", "Yerevan"),
                    new Gamer(4L, "Hayk Hovhannisyan 4", "haik.hovhanisyan4@gmail.com", "Armenia", "Yerevan")
            );

            // Takken 7 game players
            var takken7Gamers = List.of(
                    new Gamer(5L, "Hayk Hovhannisyan 5", "haik.hovhanisyan5@gmail.com", "Armenia", "Yerevan"),
                    new Gamer(6L, "Hayk Hovhannisyan 6", "haik.hovhanisyan6@gmail.com", "Armenia", "Yerevan"),
                    new Gamer(7L, "Hayk Hovhannisyan 7", "haik.hovhanisyan7@gmail.com", "Armenia", "Yerevan"),
                    new Gamer(8L, "Hayk Hovhannisyan 8", "haik.hovhanisyan8@gmail.com", "Armenia", "Yerevan")
            );

            // Mortal Combat 11game players
            var mortalCombat11Gamers = List.of(
                    new Gamer(9L, "Hayk Hovhannisyan 9", "haik.hovhanisyan9@gmail.com", "Armenia", "Yerevan"),
                    new Gamer(10L, "Hayk Hovhannisyan 10", "haik.hovhanisyan10@gmail.com", "Armenia", "Yerevan"),
                    new Gamer(11L, "Hayk Hovhannisyan 11", "haik.hovhanisyan11@gmail.com", "Armenia", "Yerevan"),
                    new Gamer(12L, "Hayk Hovhannisyan 12", "haik.hovhanisyan12@gmail.com", "Armenia", "Yerevan")
            );

            repository.save(new Game(1L, "FIFA22", GameLevel.PRO, fifa22Gamers));
            repository.save(new Game(2L, "TAKKEN 7", GameLevel.N00B, takken7Gamers));
            repository.save(new Game(3L, "MORTAL COMBAT 11", GameLevel.INVINCIBLE, mortalCombat11Gamers));

            log.info("findByIdAndGameLevel 1L and PRO : {}", repository.findByIdAndGameLevel(1L, GameLevel.PRO).get());
            log.info("findByIdAndGameLevel 2L and N00B : {}", repository.findByIdAndGameLevel(2L, GameLevel.N00B).get());
            log.info("findByIdAndGameLevel 3L and INVINCIBLE : {}", repository.findByIdAndGameLevel(3L, GameLevel.INVINCIBLE).get());
        };
    }

}
