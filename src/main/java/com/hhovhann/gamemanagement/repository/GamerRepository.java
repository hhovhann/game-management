package com.hhovhann.gamemanagement.repository;

import com.hhovhann.gamemanagement.entity.Gamer;
import com.hhovhann.gamemanagement.entity.data.Level;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GamerRepository extends JpaRepository<Gamer, Long> {
    List<Gamer> findByLevel(Level level);

    List<Gamer> findByLevelAndGame_id(Level level, Long gameId);

    List<Gamer> findByGame_idAndLevelAndCountryAndCity(Long gameId, Level level, String country, String city);
}
