
package com.capg.onlinesportsshopee.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.onlinesportsshopee.bean.Customer;
import com.capg.onlinesportsshopee.exceptions.CustomerServiceException;
import com.capg.onlinesportsshopee.model.CustomerDTO;
import com.capg.onlinesportsshopee.service.ICustomerService;
/*
 * Author : THEEPAK PRAKASH P
 * Version : 1.0
 * Date : 07-04-2021
 * Description : This is  Customer Controller 
*/
@RestController
@RequestMapping("/api/oss")
@CrossOrigin(origins = "http://localhost:3000")
public class CustomerController {

	@Autowired
	private ICustomerService customerService;
	
	final Logger LOGGER =LoggerFactory.getLogger(this.getClass());

	@PostMapping("/addCustomer")
	public ResponseEntity<CustomerDTO> addCustomer(@RequestBody Customer customer) {
		LOGGER.info("Add Customer executed");
		CustomerDTO resultcustomer = customerService.addCustomer(customer);
		return new ResponseEntity<CustomerDTO>(resultcustomer, HttpStatus.OK);

	}

	@DeleteMapping("/deleteCustomer/{id}")
	public ResponseEntity<CustomerDTO> deleteCustomer(@PathVariable long id) throws CustomerServiceException {
		LOGGER.info("Delete Customer executed");
		CustomerDTO resultcustomer = customerService.removeCustomer(id);
		return new ResponseEntity<CustomerDTO>(resultcustomer, HttpStatus.OK);

	}

	@PutMapping("/updateCustomer")
	public ResponseEntity<CustomerDTO> updateCustomer(@RequestBody Customer customer) {
		LOGGER.info("Update Customer executed");
		CustomerDTO resultCustomer = customerService.updateCustomer(customer);
		return new ResponseEntity<CustomerDTO>(resultCustomer, HttpStatus.OK);
	}

	@GetMapping("/getCustomer/{id}")
	public ResponseEntity<CustomerDTO> getCustomer(@PathVariable long id) throws CustomerServiceException {
		LOGGER.info("Get Customer by ID executed");
		CustomerDTO resultCustomer = customerService.getCustomer(id);
		return new ResponseEntity<CustomerDTO>(resultCustomer, HttpStatus.OK);
	}

	@GetMapping("/getAllCustomers")
	public ResponseEntity<List<CustomerDTO>> getAllCustomers() {
		LOGGER.info("Get all Customers executed");
		List<CustomerDTO> resultCustomer = customerService.getAllCustomers();
		return new ResponseEntity<List<CustomerDTO>>(resultCustomer, HttpStatus.OK);
	}
}
