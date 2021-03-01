package com.antarctica.antarcticalab.ressources.gateway;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.antarctica.antarcticalab.dto.ProductColorSize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.antarctica.antarcticalab.dto.Clothes;

@RestController
@RequestMapping("/public/clothes-spec")
public class ClothesSpecController {

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

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Clothes>> getClothesById(@PathVariable Long id) throws Exception {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Optional<Clothes>> entity = new HttpEntity<Optional<Clothes>>(headers);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        ResponseEntity<Optional<Clothes>> body = null;

        try {
            body = restTemplate
                    .exchange("http://localhost:8081/clothes/" + id, HttpMethod.GET, entity, new ParameterizedTypeReference<Optional<Clothes>>() {
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }

        return body;
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<List<ProductColorSize>>getProductSpecByProductId(@PathVariable Long id){
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<List<ProductColorSize>> entity = new HttpEntity<List<ProductColorSize>>(headers);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        ResponseEntity<List<ProductColorSize>> body = null;

        try {
            body = restTemplate
                    .exchange("http://localhost:8081/product-spec/product/" + id, HttpMethod.GET, entity, new ParameterizedTypeReference<List<ProductColorSize>>() {
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }

        return body;
    }


    @GetMapping("/string")
    public String gettest() {
        return "hello";
    }
}
