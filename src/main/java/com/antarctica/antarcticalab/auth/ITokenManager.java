package com.antarctica.antarcticalab.auth;

public interface ITokenManager {
	TokenHolder parseToken(String token);
}
