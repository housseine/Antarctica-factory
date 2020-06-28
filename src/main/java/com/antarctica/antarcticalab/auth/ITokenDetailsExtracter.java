package com.antarctica.antarcticalab.auth;

import org.springframework.stereotype.Component;

@Component
public interface ITokenDetailsExtracter {
	String getEmail();
	String getIssuer();
	String getName();
	String getUid();
}
