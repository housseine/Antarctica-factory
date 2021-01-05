package com.bnpparibas.dsira.creditconsonormesapi.exception;

public class CustomException extends CustomAbstractException {

	static final long serialVersionUID = 1L;

	public CustomException(ApiError apiError) {
		super(apiError);
	}

}
