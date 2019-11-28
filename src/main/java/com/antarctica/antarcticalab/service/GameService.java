package com.antarctica.antarcticalab.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.antarctica.antarcticalab.entity.Game;
import com.antarctica.antarcticalab.repository.IGameRepository;
@Service
public class GameService implements IGameService {
	@Autowired
	IGameRepository gameRepository;

	@Override
	public void addGame(Game game) {
		gameRepository.saveAndFlush(game);

	}

	@Override
	public List<Game> getAllGames() {
		return gameRepository.findAll();
	}

	@Override
	public void deleteGame(Game game) {
		gameRepository.delete(game);
	}

	@Override
	public void updateGame(Game game) {
		gameRepository.saveAndFlush(game);

	}

}
