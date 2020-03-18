package com.antarctica.antarcticalab.infra.bdd;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.antarctica.antarcticalab.domain.IGameDomainRepository;
import com.antarctica.antarcticalab.entity.Game;

@Component
public class GameRepository implements IGameDomainRepository{

	@Autowired
	IGameRepository igameRepository;

	@Override
	public Game addGame(Game game) {
		return igameRepository.saveAndFlush(game);

	}

	@Override
	public List<Game> getAllGames() {
		return igameRepository.findAll();
	}

	@Override
	public void deleteGame(Long gameId) {
		igameRepository.deleteById(gameId);
	}

	@Override
	public void updateGame(Game game) {
		igameRepository.saveAndFlush(game);

	}

	@Override
	public Optional<Game> getGameById(Long id) {
		return igameRepository.findById(id);
	}

	@Override
	public List<Game> getGameByName(String term) {
		return igameRepository.findByNameContainingIgnoreCase(term);
	}

}
