package com.hhovhann.gamemanagement.repository;

import com.hhovhann.gamemanagement.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
}
