package com.antarctica.antarcticalab.dto;

public class PayloadResponseLogin {
	boolean loggedin;

	public PayloadResponseLogin(boolean loggedin) {
		this.loggedin = loggedin;
	}

	public PayloadResponseLogin() {
		super();
	}

	public boolean isLoggedin() {
		return loggedin;
	}

	public void setLoggedin(boolean loggedin) {
		this.loggedin = loggedin;
	}

}
