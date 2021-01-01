package com.antarctica.antarcticalab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.antarctica.antarcticalab.config.AppProperties;

@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
public class AntarcticaLabApplication {

	public static void main(String[] args) {
		SpringApplication.run(AntarcticaLabApplication.class, args);
	}
}
