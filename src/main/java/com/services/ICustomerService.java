
package com.services;

import java.util.List;

import com.bean.Customer;
import com.exceptions.CustomerServiceException;
import com.model.CustomerDTO;


 //Description : This is Customer Service Interface Layer that provides Interface services to Customer

public interface ICustomerService {
	public CustomerDTO addCustomer(Customer customer) throws CustomerServiceException;
	public CustomerDTO removeCustomer(long custId)throws CustomerServiceException;
	public CustomerDTO updateCustomer(Customer customer)throws CustomerServiceException;
	public CustomerDTO getCustomer(long custId)throws CustomerServiceException;
	public List<CustomerDTO> getAllCustomers()throws CustomerServiceException; 
}

