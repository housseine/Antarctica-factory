package com.antarctica.antarcticalab.service;

import java.util.List;
import java.util.Optional;

import com.antarctica.antarcticalab.entity.Game;

public interface IGameService {
	Game addGame(Game game);

	List<Game> getAllGames();

	void deleteGame(Long gameId);

	void updateGame(Game game);

	Optional<Game> getGameById(Long id);

	List<Game> getGameByName(String term);

}
