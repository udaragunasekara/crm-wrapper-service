package com.ug.crm.exception;

import lombok.Getter;

@Getter
public class ProfileNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String errorCode;

	public ProfileNotFoundException(String message) {
		super(message);
		this.errorCode = "NOT_FOUND";
	}
}
