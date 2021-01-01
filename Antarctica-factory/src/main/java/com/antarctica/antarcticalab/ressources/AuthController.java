package com.antarctica.antarcticalab.ressources;

import java.net.URI;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpCookie;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.antarctica.antarcticalab.common.enumm.AuthProvider;
import com.antarctica.antarcticalab.dto.ApiResponse;
import com.antarctica.antarcticalab.dto.LoginRequest;
import com.antarctica.antarcticalab.dto.PayloadResponseLogin;
import com.antarctica.antarcticalab.dto.SignUpRequest;
import com.antarctica.antarcticalab.dto.TokenPayLoad;
import com.antarctica.antarcticalab.entity.User;
import com.antarctica.antarcticalab.exception.BadRequestException;
import com.antarctica.antarcticalab.infra.bdd.UserRepository;
import com.antarctica.antarcticalab.security.TokenProvider;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private TokenProvider tokenProvider;

	@Autowired
	RestTemplate restTemplate;

	@PostMapping("/login")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest,
			@CookieValue(name = "testHttp", required = false) String testHttp) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		String token = tokenProvider.createToken(authentication);
		HttpHeaders headers = tokenProvider.storeToken(token);
		return ResponseEntity.ok().headers(headers).body(new PayloadResponseLogin(true));

	}

	@GetMapping("/logingoogle")
	public ResponseEntity<?> loginGoogle() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		String resp = restTemplate.exchange(
				"http://localhost:8080/oauth2/authorize/google?redirect_uri=http://localhost:8080/oauth2/redirect",
				HttpMethod.GET, entity, String.class).getBody();
		System.out.println(resp);
		return ResponseEntity.ok().headers(headers).body(resp);

	}

	@GetMapping("/sendToken")
	public ResponseEntity<TokenPayLoad> sendToken(@RequestParam("token") String token, HttpServletResponse httpServletResponse) {
		HttpCookie cookie = tokenProvider.makeTokenCookie(token);
		httpServletResponse.addHeader(HttpHeaders.SET_COOKIE, cookie.toString());
		TokenPayLoad tokenPayLoad = new TokenPayLoad();
		tokenPayLoad.setTokenCookiePayLoad("access");
		System.out.println("token: " + token);
		System.out.println("cookie: " + cookie);
		return new ResponseEntity<TokenPayLoad>(tokenPayLoad, HttpStatus.OK);
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {
		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			throw new BadRequestException("Email address already in use.");
		}

		// Creating user's account
		User user = new User();
		user.setName(signUpRequest.getName());
		user.setEmail(signUpRequest.getEmail());
		user.setPassword(signUpRequest.getPassword());
		user.setProvider(AuthProvider.local);

		user.setPassword(passwordEncoder.encode(user.getPassword()));

		User result = userRepository.save(user);

		URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/user/me")
				.buildAndExpand(result.getId()).toUri();

		return ResponseEntity.created(location).body(new ApiResponse(true, "User registered successfully@"));
	}

	@GetMapping("/gettoken")
	String getToken(@CookieValue(name = "myCookieName", required = false) String testHttp) {
		System.out.println("cookie: " + testHttp);
		return testHttp;
	}

	@GetMapping(path = "/putsession")
	public void putSess(HttpSession session) {
		session.setAttribute("valSess", "true");
	}

	@GetMapping(path = "/putreqsession")
	public void putSessReq(HttpServletRequest req) {
		req.getSession().setAttribute("myvar", "hello");
	}

	@GetMapping(path = "/getsession")
	public String getSess(HttpSession session) {
		return (String) session.getAttribute("myvar");
	}

}
