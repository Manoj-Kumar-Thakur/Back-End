package com.exceptions;


public class LoginNotFoundException extends Exception{
	
	private static final long serialVersionUID = 1L;
	
	public LoginNotFoundException(String message) {
	super(message);
	}

}

