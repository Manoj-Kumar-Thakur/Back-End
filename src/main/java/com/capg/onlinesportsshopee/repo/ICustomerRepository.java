package com.capg.onlinesportsshopee.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.onlinesportsshopee.bean.Customer;

/*
 * Author : THEEPAK PRAKASH P
 * Version : 1.0
 * Date : 04-04-2021
 * Description : This is Customer Repository
*/

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
