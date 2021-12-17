package com.capg.onlinesportsshopee.exceptions;

/* Author : AAYUSHI CHANSORIYA
 * Version : 1.0
 * Date : 02-04-2021
 * Description : This is ProductService Exception
 */
public class ProductServiceException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public ProductServiceException(String message) {
		super(message);
	}
	
}