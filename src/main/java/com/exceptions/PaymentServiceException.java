package com.exceptions;



public class PaymentServiceException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public PaymentServiceException(String message) {
		super(message);
	}

}
