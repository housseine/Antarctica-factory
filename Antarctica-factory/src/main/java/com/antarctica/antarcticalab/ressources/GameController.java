package com.antarctica.antarcticalab.ressources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.antarctica.antarcticalab.entity.Game;
import com.antarctica.antarcticalab.service.GameService;

@RestController()
@RequestMapping("/games")
public class GameController {
	@Autowired
	GameService gameService;

	@GetMapping("/getall")
	public ResponseEntity<List<Game>> getAllGames() {
		return new ResponseEntity<List<Game>>(gameService.getAllGames(), HttpStatus.OK);
	}

	@PostMapping()
	public ResponseEntity<Game> addGame(@RequestBody Game game) {
		return new ResponseEntity<Game>(gameService.addGame(game), HttpStatus.OK);
	}

	@PatchMapping()
	public void updateGame(@RequestBody Game game) {
		gameService.updateGame(game);
	}

	@DeleteMapping("/{id}")
	void deleteGame(@PathVariable Long id) {
		gameService.deleteGame(id);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<Game>> getGameById(@PathVariable Long id) {
		return new ResponseEntity<Optional<Game>>(gameService.getGameById(id), HttpStatus.OK);
	}

	@GetMapping()
	public ResponseEntity<List<Game>> getGameByName(@RequestParam("term") String term) {
		return new ResponseEntity<List<Game>>(gameService.getGameByName(term), HttpStatus.OK);

	}
}
