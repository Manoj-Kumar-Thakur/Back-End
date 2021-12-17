
package com.capg.onlinesportsshopee.service;

import java.util.List;

import com.capg.onlinesportsshopee.bean.Customer;
import com.capg.onlinesportsshopee.exceptions.CustomerServiceException;
import com.capg.onlinesportsshopee.model.CustomerDTO;

/*
 * Author : THEEPAK PRAKASH P
 * Version : 1.0
 * Date : 04-04-2021
 * Description : This is Customer Service Interface Layer that provides Interface services to Customer
*/
public interface ICustomerService {
	public CustomerDTO addCustomer(Customer customer) throws CustomerServiceException;
	public CustomerDTO removeCustomer(long custId)throws CustomerServiceException;
	public CustomerDTO updateCustomer(Customer customer)throws CustomerServiceException;
	public CustomerDTO getCustomer(long custId)throws CustomerServiceException;
	public List<CustomerDTO> getAllCustomers()throws CustomerServiceException; 
}

