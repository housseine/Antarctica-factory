package com.bnpparibas.dsira.creditconsonormesapi.exception;

import org.springframework.http.HttpStatus;

public abstract class CustomAbstractException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private ApiError apiError;
	private HttpStatus httpstatus;

	public CustomAbstractException(ApiError apiError) {
		super(errorsBuilder(apiError));
		this.apiError = apiError;
	}

	public ApiError getApiError() {
		return apiError;
	}

	public HttpStatus getHttpstatus() {
		return httpstatus;
	}
private static String errorsBuilder(ApiError apiError) {
	if(apiError!=null) {
		if(apiError.getErrors()!=null) {
			return apiError.getErrors().toString();
		}
	}
	return null;
}
}
