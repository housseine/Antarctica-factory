package com.antarctica.antarcticalab.auth.firebase;

import com.antarctica.antarcticalab.auth.TokenHolder;
import com.google.firebase.auth.FirebaseToken;

public class TokenMapper {

	public static TokenHolder mapFirebaseTokenToTokenHolder(FirebaseToken token) {
		TokenHolder tokenHolder = new TokenHolder(token.getEmail(), token.getIssuer(), token.getName(), token.getUid());
		return tokenHolder;
	}
}
