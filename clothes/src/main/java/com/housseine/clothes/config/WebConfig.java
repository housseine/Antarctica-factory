package com.housseine.clothes.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	/*
	 * @Override public void addCorsMappings(CorsRegistry corsRegistry) {
	 * corsRegistry.addMapping("/**").allowedOrigins("http://localhost:4200").
	 * allowedMethods("GET", "PUT", "POST", "PATCH", "DELETE"); //
	 * corsRegistry.addMapping("/**").allowedOrigins(
	 * "https://antarctica-lab.herokuapp.com/").allowedMethods("GET", "PUT", "POST",
	 * // "PATCH", "DELETE"); corsRegistry.addMapping("/**").allowedOrigins(
	 * "https://antarctica-lab-web.firebaseapp.com").allowedMethods("GET", "PUT",
	 * "POST", "PATCH", "DELETE"); }
	 */

	private final long MAX_AGE_SECS = 3600;

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
				.allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS")
				.allowedOrigins("http://localhost:8080")
				.allowedOrigins("http://localhost:4200")
				.allowedOrigins("https://antarctica-lab-web.web.app")
				.allowedOrigins("https://antarctica-lab.herokuapp.com")
				.allowedOrigins("https://antarctica-lab.herokuapp.com")
				.allowedOrigins("*")
				.allowedHeaders("*")
				.allowCredentials(true)
				.maxAge(MAX_AGE_SECS);
	}

}
