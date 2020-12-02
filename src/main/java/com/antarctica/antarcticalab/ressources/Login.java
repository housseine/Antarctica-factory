package com.antarctica.antarcticalab.ressources;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpCookie;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.antarctica.antarcticalab.security.TokenProvider;

@RestController
public class Login {
	@Autowired
	private TokenProvider tokenProvider;

	@GetMapping("/oauth2/redirect")
	void  getWelcom(@RequestParam(value = "token") String token, HttpServletResponse httpServletResponse) {
		httpServletResponse.setHeader("Location", "http://localhost:4200");
		httpServletResponse.setStatus(302);
		if(token!=null) {
			HttpCookie cookie=tokenProvider.makeTokenCookie(token);
			httpServletResponse.addHeader(HttpHeaders.SET_COOKIE, cookie.toString());
			httpServletResponse.addHeader("access", "true");	
		}
	}

}
