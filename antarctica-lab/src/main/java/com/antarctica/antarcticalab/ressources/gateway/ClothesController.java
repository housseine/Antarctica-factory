package com.antarctica.antarcticalab.ressources.gateway;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.antarctica.antarcticalab.dto.Clothes;

@RestController
@RequestMapping("/public/clothes")
public class ClothesController {

	@Autowired
	RestTemplate restTemplate;

	@GetMapping("/all")
	// @PreAuthorize("hasRole('ROLE_USER')")
	public ResponseEntity<List<Clothes>> getAllClothes() throws Exception {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<List<Clothes>> entity = new HttpEntity<List<Clothes>>(headers);
		ResponseEntity<List<Clothes>> body = null;
			body = restTemplate
					.exchange("http://localhost:8081/clothes/all", HttpMethod.GET, null, new ParameterizedTypeReference<List<Clothes>>() {
		            });

		return body;
	}

	@GetMapping("/string")
	public String gettest() {
		return "hello";
	}
}
