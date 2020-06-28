package com.antarctica.antarcticalab.auth.firebase;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.antarctica.antarcticalab.auth.ITokenManager;
import com.antarctica.antarcticalab.auth.TokenHolder;

public class FirebaseFilter extends OncePerRequestFilter {
	private static String HEADER_NAME = "X-Authorization-Firebase";
	@Autowired
	ITokenManager tokenManager;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String xAuth = request.getHeader(HEADER_NAME);
		if(xAuth.isEmpty()||xAuth==null||xAuth==null) {
			filterChain.doFilter(request, response);
			return;
		}else {
			try {
				TokenHolder TokenHolder = tokenManager.parseToken(xAuth);

				String userName = TokenHolder.getUid();

				Authentication auth = new AuthenticationToken(userName, TokenHolder);
				SecurityContextHolder.getContext().setAuthentication(auth);

				filterChain.doFilter(request, response);
			} catch (Exception e) {
				throw new SecurityException(e);
			}
		}
	}

}
