package com.antarctica.antarcticalab.infra;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
	public void addGame(@RequestBody Game game) {
		gameService.addGame(game);
	}

	@PatchMapping()
	public void updateGame(@RequestBody Game game) {
		gameService.updateGame(game);
	}

	@DeleteMapping()
	void deleteGame(@RequestBody Game game) {
		gameService.deleteGame(game);
	}

}
