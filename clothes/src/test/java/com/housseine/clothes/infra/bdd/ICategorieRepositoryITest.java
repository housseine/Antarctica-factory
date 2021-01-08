package com.housseine.clothes.infra.bdd;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.housseine.clothes.entity.Categorie;

//@RunWith(SpringJUnit4ClassRunner.class)
//@DataJpaTest
//@ComponentScan(basePackages = "com.housseine.clothes.*")
//@ContextConfiguration
//@SpringBootTest(classes = ClothesApplication.class)
@ContextConfiguration(classes = TestConfig.class)
@EnableJpaRepositories(basePackages = {"com.housseine.*"})
@EntityScan("com.housseine.clothes.entity")



@RunWith(SpringRunner.class)
@DataJpaTest
class ICategorieRepositoryITest {

    @Autowired
    private ICategorieRepository iCategorieRepository;
    
    @Test
    public void whenFindByName_thenReturnEmployee() {
        // given
        Categorie categorie = new Categorie("women");
        iCategorieRepository.save(categorie);

        // when
        List<Categorie> found = iCategorieRepository.findByLabelContainingIgnoreCase(categorie.getLabel());

        // then
        assertThat(found.get(0).getLabel()).isEqualTo(categorie.getLabel());
    }

}
