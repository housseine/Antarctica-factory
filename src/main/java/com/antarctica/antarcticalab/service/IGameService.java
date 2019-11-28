package com.antarctica.antarcticalab.service;

import java.util.List;

import com.antarctica.antarcticalab.entity.Game;

public interface IGameService {
	void addGame(Game game);

	List<Game> getAllGames();

	void deleteGame(Game game);

	void updateGame(Game game);

}
