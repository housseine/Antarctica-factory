package com.antarctica.antarcticalab.auth;

import com.antarctica.antarcticalab.auth.firebase.TokenMapper;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseToken;

public class TokenManager implements ITokenManager {

	@Override
	public TokenHolder parseToken(String token) {
		if (token.isEmpty() || token == "" || token == null) {
			throw new IllegalArgumentException("FirebaseTokenBlank");
		}
		try {
			FirebaseToken decodedToken = FirebaseAuth.getInstance().verifyIdToken(token);
			TokenHolder tokenHolder = TokenMapper.mapFirebaseTokenToTokenHolder(decodedToken);
			return tokenHolder;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}
