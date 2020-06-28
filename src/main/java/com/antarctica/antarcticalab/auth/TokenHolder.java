package com.antarctica.antarcticalab.auth;

public class TokenHolder {

	private String email;
	private String issuer;
	private String name;
	private String uid;

	public TokenHolder() {
	}

	public TokenHolder(String email, String issuer, String name, String uid) {
		super();
		this.email = email;
		this.issuer = issuer;
		this.name = name;
		this.uid = uid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIssuer() {
		return issuer;
	}

	public void setIssuer(String issuer) {
		this.issuer = issuer;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

}
