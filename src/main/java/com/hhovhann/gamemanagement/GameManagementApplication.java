package com.hhovhann.gamemanagement;

import com.hhovhann.gamemanagement.entity.Game;
import com.hhovhann.gamemanagement.entity.Gamer;
import com.hhovhann.gamemanagement.entity.data.Level;
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
                    new Gamer(1L, "Hayk Hovhannisyan 1", Level.PRO, "Armenia", "Yerevan"),
                    new Gamer(2L, "Hayk Hovhannisyan 2", Level.INVINCIBLE, "Armenia", "Yerevan"),
                    new Gamer(3L, "Hayk Hovhannisyan 3", Level.INVINCIBLE, "Armenia", "Yerevan"),
                    new Gamer(4L, "Hayk Hovhannisyan 4", Level.N00B, "Armenia", "Yerevan")
            );

            // Takken 7 game players
            var takken7Gamers = List.of(
                    new Gamer(5L, "Hayk Hovhannisyan 5", Level.PRO, "Armenia", "Yerevan"),
                    new Gamer(6L, "Hayk Hovhannisyan 6", Level.INVINCIBLE, "Armenia", "Yerevan"),
                    new Gamer(7L, "Hayk Hovhannisyan 7", Level.INVINCIBLE, "Armenia", "Yerevan"),
                    new Gamer(8L, "Hayk Hovhannisyan 8", Level.N00B, "Armenia", "Yerevan")
            );

            // Mortal Combat 11game players
            var mortalCombat11Gamers = List.of(
                    new Gamer(9L, "Hayk Hovhannisyan 9", Level.PRO, "Armenia", "Yerevan"),
                    new Gamer(10L, "Hayk Hovhannisyan 10", Level.INVINCIBLE, "Armenia", "Yerevan"),
                    new Gamer(11L, "Hayk Hovhannisyan 11", Level.INVINCIBLE, "Armenia", "Yerevan"),
                    new Gamer(12L, "Hayk Hovhannisyan 12", Level.N00B, "Armenia", "Yerevan")
            );

            repository.save(new Game(1L, "FIFA22", fifa22Gamers));
            repository.save(new Game(2L, "TAKKEN 7", takken7Gamers));
            repository.save(new Game(3L, "MORTAL COMBAT 11", mortalCombat11Gamers));

        };
    }

}
