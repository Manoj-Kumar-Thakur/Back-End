package com.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bean.Customer;

 // Description : This is Customer Repository


@Repository
public interface ICustomerRepository extends JpaRepository<Customer,Long>{
	
	
	
	
	
	
	/*
	 * public Customer addCustomer(Customer customer); 
	 * public Customer removeCustomer(long custId); 
	 * public Customer updateCustomer(long custId, Customer customer); 
	 * public Customer getCustomer(long custId); public
	 * List<Customer> getAllCustomers();
	 */ 
}
