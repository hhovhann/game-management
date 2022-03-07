package com.hhovhann.gamemanagement.repository;

import com.hhovhann.gamemanagement.entity.Game;
import com.hhovhann.gamemanagement.entity.data.Geography;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GameRepository extends CrudRepository<Game, Long> {

    Optional<Game> findByIdAndGameLevel(Long id, String gameLevel);

    Optional<Game> findByIdAndGameLevelAndGamersGeography(Long id, String gameLevel, Geography geography);

}
