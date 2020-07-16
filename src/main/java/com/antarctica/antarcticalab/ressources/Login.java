package com.antarctica.antarcticalab.ressources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Login {
	@GetMapping("/oauth2/redirect")
	String getWelcom() {
		return "wlcm";
	}

}
