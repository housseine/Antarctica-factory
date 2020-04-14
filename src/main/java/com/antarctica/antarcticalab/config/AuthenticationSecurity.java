package com.antarctica.antarcticalab.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

public class AuthenticationSecurity extends GlobalAuthenticationConfigurerAdapter{
	
	@Autowired
	private UserDetailsService userService;
	
	
	@Override
	public void init(AuthenticationManagerBuilder auth) {
		try {
			auth.userDetailsService(userService);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
