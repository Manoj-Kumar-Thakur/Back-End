package com.capg.onlinesportsshopee.exceptions;
/*
 * Author : THEEPAK PRAKASH P
 * Version : 1.0
 * Date : 02-04-2021
 * Description : This is Customer Service Exception
*/
public class CustomerServiceException extends RuntimeException {
private static final long serialVersionUID = 1L;
	
	public CustomerServiceException(String msg) {
		super(msg);
	}

}
