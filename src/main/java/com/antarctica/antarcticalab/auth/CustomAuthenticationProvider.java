package com.antarctica.antarcticalab.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;

import com.antarctica.antarcticalab.auth.firebase.AuthenticationToken;
import com.antarctica.antarcticalab.service.IUserService;

public class CustomAuthenticationProvider implements AuthenticationProvider {
	@Autowired
	IUserService userService;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		if (!supports(authentication.getClass())) {
			return null;
		}

		AuthenticationToken authenticationToken = (AuthenticationToken) authentication;
		UserDetails userDetails = userService.loadUserByUsername(authenticationToken.getName());
		if (userDetails == null) {
			// TODO ADD EXCPTION
			return null;
		}
		authenticationToken = new AuthenticationToken(userDetails, authentication.getCredentials(),
				userDetails.getAuthorities());

		return authenticationToken;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return (AuthenticationToken.class.isAssignableFrom(authentication));
	}

}
