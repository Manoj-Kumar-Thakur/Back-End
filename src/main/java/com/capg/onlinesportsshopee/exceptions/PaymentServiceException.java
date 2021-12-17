package com.capg.onlinesportsshopee.exceptions;


/*
 * Author : SYED SAMSUDEEN A
 * Version : 1.0
 * Date : 04-04-2021
 * Description : This is Payment Service Exception  
*/
public class PaymentServiceException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public PaymentServiceException(String message) {
		super(message);
	}

}
