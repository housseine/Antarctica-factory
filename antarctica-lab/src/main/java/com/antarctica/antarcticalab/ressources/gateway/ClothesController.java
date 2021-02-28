package com.antarctica.antarcticalab.ressources.gateway;

import com.antarctica.antarcticalab.dto.Clothes;
import com.antarctica.antarcticalab.dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/public/clothes")
public class ClothesController {
    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAllclothes() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<List<Clothes>> entity = new HttpEntity<List<Clothes>>(headers);
        ResponseEntity<List<Product>> body = null;
        body = restTemplate
                .exchange("http://localhost:8081/product/all", HttpMethod.GET, entity, new ParameterizedTypeReference<List<Product>>() {
                });
        return body;
    }
}
