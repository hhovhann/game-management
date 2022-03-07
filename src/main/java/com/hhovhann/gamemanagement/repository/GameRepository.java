package com.hhovhann.gamemanagement.repository;

import com.hhovhann.gamemanagement.entity.Game;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends CrudRepository<Game, Long> {
}
