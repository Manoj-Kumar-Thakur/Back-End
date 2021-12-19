package com.exceptions;

public class CustomerServiceException extends RuntimeException {
private static final long serialVersionUID = 1L;
	
	public CustomerServiceException(String msg) {
		super(msg);
	}

}
