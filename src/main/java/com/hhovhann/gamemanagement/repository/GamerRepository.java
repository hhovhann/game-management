package com.hhovhann.gamemanagement.repository;

import com.hhovhann.gamemanagement.entity.Gamer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GamerRepository extends CrudRepository<Gamer, Long> {
}
