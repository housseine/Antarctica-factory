package com.housseine.clothes.resource;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.housseine.clothes.entity.Categorie;
import com.housseine.clothes.service.ICategorieService;

@WebMvcTest(controllers = CategorieController.class)
class CategorieControllerTest {
	@Autowired
    private MockMvc mvc;

    @MockBean
    private ICategorieService service;

    @Test
    public void givenEmployees_whenGetEmployees_thenReturnJsonArray()
      throws Exception {
        
        Categorie categorie = new Categorie("Kids");

        List<Categorie> allCategories = Arrays.asList(categorie);

        when(service.getAllcategories()).thenReturn(allCategories);

        mvc.perform(get("/categorie/getall")
          .contentType(MediaType.APPLICATION_JSON))
          .andExpect(status().isOk())
          .andExpect(jsonPath("$.length()", is(1)))
          .andExpect(jsonPath("$[0].label", is(categorie.getLabel())));
    }

	@Test
	public void test() {
		assertTrue(true);
	}
}
