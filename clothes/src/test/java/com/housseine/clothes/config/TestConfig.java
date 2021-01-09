package com.housseine.clothes.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "com.housseine.clothes.*")
//@EnableJpaRepositories(basePackages = "com.housseine.clothes.infra.bdd")
@PropertySource("application-dev.properties")
//@EnableTransactionManagement	
public class TestConfig {

}
