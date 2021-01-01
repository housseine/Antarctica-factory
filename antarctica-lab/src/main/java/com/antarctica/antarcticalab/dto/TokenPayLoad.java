package com.antarctica.antarcticalab.dto;

public class TokenPayLoad {
	String tokenCookiePayLoad;

	public TokenPayLoad() {
		super();
	}

	public TokenPayLoad(String tokenCookiePayLoad) {
		super();
		this.tokenCookiePayLoad = tokenCookiePayLoad;
	}

	public String getTokenCookiePayLoad() {
		return tokenCookiePayLoad;
	}

	public void setTokenCookiePayLoad(String tokenCookiePayLoad) {
		this.tokenCookiePayLoad = tokenCookiePayLoad;
	}

}
