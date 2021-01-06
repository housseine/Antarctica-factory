//package com.housseine.clothes.infra.bdd;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//import java.util.List;
//
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.domain.EntityScan;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
//import org.springframework.boot.test.context.TestConfiguration;
//import org.springframework.context.annotation.Bean;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import com.housseine.clothes.domain.ICategorieDomainRepository;
//import com.housseine.clothes.entity.Categorie;
//
//@RunWith(SpringRunner.class)
//@DataJpaTest
//@ContextConfiguration(classes = {ICategorieDomainRepository.class, CategorieRepository.class})
//@EnableJpaRepositories(basePackages = {"com.housseine.*"})
//@EntityScan("com.housseine.clothes.entity")
//class ICategorieRepositoryITest {
//
//    @TestConfiguration
//    static class EmployeeServiceImplTestContextConfiguration {
//        @Bean
//        public ICategorieDomainRepository employeeService() {
//            return new CategorieRepository();
//        }
//    }
//	
//	@Autowired
//    private TestEntityManager entityManager;
//
//    @Autowired
//    private ICategorieRepository iCategorieRepository;
//    
//    @Test
//    public void whenFindByName_thenReturnEmployee() {
//        // given
//        Categorie categorie = new Categorie("Kinder");
//        entityManager.persist(categorie);
//        entityManager.flush();
//
//        // when
//        List<Categorie> found = iCategorieRepository.findByLabelContainingIgnoreCase(categorie.getLabel());
//
//        // then
//        assertThat(found.get(0).getLabel()).isEqualTo(categorie.getLabel());
//    }
//
//}
