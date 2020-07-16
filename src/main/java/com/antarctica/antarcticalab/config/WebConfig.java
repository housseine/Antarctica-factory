package com.antarctica.antarcticalab.config;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {
/*
	@Override
	public void addCorsMappings(CorsRegistry corsRegistry) {
		corsRegistry.addMapping("/**").allowedOrigins("http://localhost:4200").allowedMethods("GET", "PUT", "POST",
				"PATCH", "DELETE");
//		corsRegistry.addMapping("/**").allowedOrigins("https://antarctica-lab.herokuapp.com/").allowedMethods("GET", "PUT", "POST",
//				"PATCH", "DELETE");
		corsRegistry.addMapping("/**").allowedOrigins("https://antarctica-lab-web.firebaseapp.com").allowedMethods("GET", "PUT", "POST",
				"PATCH", "DELETE");
	}*/
	
	  private final long MAX_AGE_SECS = 3600;

	    @Override
	    public void addCorsMappings(CorsRegistry registry) {
	        registry.addMapping("/**")
	        .allowedOrigins("*")
	        .allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS")
	        .allowedHeaders("*")
	        .allowCredentials(true)
	        .maxAge(MAX_AGE_SECS);
	    }
	    

}
