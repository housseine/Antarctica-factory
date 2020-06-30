package com.antarctica.antarcticalab.ressources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

	@GetMapping(path = "/getMyresource")
	String getHello() {
		return "hello";
	}

}
