package com.antarctica.antarcticalab.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.antarctica.antarcticalab.entity.Game;
import com.antarctica.antarcticalab.repository.IGameRepository;

@Service
public class GameService implements IGameService {
	@Autowired
	IGameRepository gameRepository;

	@Override
	public Game addGame(Game game) {
		return gameRepository.saveAndFlush(game);

	}

	@Override
	public List<Game> getAllGames() {
		return gameRepository.findAll();
	}

	@Override
	public void deleteGame(Long gameId) {
		gameRepository.deleteById(gameId);
	}

	@Override
	public void updateGame(Game game) {
		gameRepository.saveAndFlush(game);

	}

	@Override
	public Optional<Game> getGameById(Long id) {
		return gameRepository.findById(id);
	}

	@Override
	public List<Game> getGameByName(String term) {
		return gameRepository.findByNameContainingIgnoreCase(term);
	}

}
