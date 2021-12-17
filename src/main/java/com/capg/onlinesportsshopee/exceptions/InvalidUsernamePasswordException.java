package com.capg.onlinesportsshopee.exceptions;

/*
 * Author : SAI MADHU BHAVANA A
 * Version : 1.0
 * Date : 06-04-2021
 * Description : This is Invalid Username Password Exception 
*/
public class InvalidUsernamePasswordException extends Exception {

	private static final long serialVersionUID = 1L;

	public InvalidUsernamePasswordException() {
	}

	public InvalidUsernamePasswordException(String message) {
		super(message);
	}
}

