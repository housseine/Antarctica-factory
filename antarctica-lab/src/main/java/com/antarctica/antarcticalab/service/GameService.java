package com.antarctica.antarcticalab.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.antarctica.antarcticalab.domain.IGameDomainRepository;
import com.antarctica.antarcticalab.entity.Game;

@Service
public class GameService implements IGameService {
	@Autowired
	IGameDomainRepository gameRepository;

	@Override
	public Game addGame(Game game) {
		return gameRepository.addGame(game);

	}

	@Override
	public List<Game> getAllGames() {
		return gameRepository.getAllGames();
	}

	@Override
	public void deleteGame(Long gameId) {
		gameRepository.deleteGame(gameId);
	}

	@Override
	public void updateGame(Game game) {
		gameRepository.updateGame(game);

	}

	@Override
	public Optional<Game> getGameById(Long id) {
		return gameRepository.getGameById(id);
	}

	@Override
	public List<Game> getGameByName(String term) {
		return gameRepository.getGameByName(term);
	}

}
