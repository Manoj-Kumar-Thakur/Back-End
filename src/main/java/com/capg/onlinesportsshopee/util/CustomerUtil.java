package com.capg.onlinesportsshopee.util;
import java.util.ArrayList;
import java.util.List;

import com.capg.onlinesportsshopee.bean.Customer;
import com.capg.onlinesportsshopee.model.CustomerDTO;

/*
 * Author : THEEPAK PRAKASH P
 * Version : 1.0
 * Date : 04-04-2021
 * Description : This is Customer Util class 
*/
public class CustomerUtil {
	
	public static List<CustomerDTO> convertToCustomerDtoList(List<Customer> list)
	{
		List<CustomerDTO> customerDTOList = new ArrayList<CustomerDTO>();
		for (Customer customer : list)
			customerDTOList.add(convertToCustomerDto(customer));
	    return customerDTOList;
	}
	
	public static Customer convertToCustomer(CustomerDTO customerDTO) {
		Customer customer = new Customer();
		
		customer.setUserId(customerDTO.getUserId());
		customer.setName(customerDTO.getName());
		customer.setEmail(customerDTO.getEmail());
		customer.setContactNo(customerDTO.getContactNo());
		customer.setDob(customerDTO.getDob());
		customer.setAddress(customerDTO.getAddress());
		
		return customer;
	}
	
	public static CustomerDTO convertToCustomerDto(Customer customer) {
		CustomerDTO customerDTO = new CustomerDTO();
		
		customerDTO.setUserId(customer.getUserId());
		customerDTO.setName(customer.getName());
		customerDTO.setEmail(customer.getEmail());
		customerDTO.setContactNo(customer.getContactNo());
		customerDTO.setDob(customer.getDob());
		customerDTO.setAddress(customer.getAddress());
		
		return customerDTO;
	}
}