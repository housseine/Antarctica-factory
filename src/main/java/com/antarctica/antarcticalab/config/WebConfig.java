package com.antarctica.antarcticalab.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

//	@Value("${spring.datasource.url}")
//	private String dbUrl;

	@Override
	public void addCorsMappings(CorsRegistry corsRegistry) {
		corsRegistry.addMapping("/**").allowedOrigins("http://localhost:4200").allowedMethods("GET", "PUT", "POST",
				"PATCH", "DELETE");
	}

//	@Bean
//	public DataSource dataSource() {
//		HikariConfig config = new HikariConfig();
//		config.setJdbcUrl(dbUrl);
//		return new HikariDataSource(config);
//	}

}
