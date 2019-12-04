package com.antarctica.antarcticalab.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.antarctica.antarcticalab.entity.Game;

@Repository
public interface IGameRepository extends JpaRepository<Game, Long>{
	List<Game> findByNameContainingIgnoreCase(String name);
}
