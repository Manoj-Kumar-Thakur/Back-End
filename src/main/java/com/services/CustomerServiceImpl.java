
package com.services;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Customer;
import com.exceptions.CustomerServiceException;
import com.model.CustomerDTO;
import com.repo.ICustomerRepository;
import com.util.CustomerUtil;
/*
 * Description : This is Customer Service Layer that provides services to Add New Customer details, Update Existing Customer details, 
 *               Delete Existing Customer details, Get Existing Customer details and Get All Existing Customer details
*/
@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private ICustomerRepository customerRepo;

	
	/*
	 * Description : This method adds Customer Details
	 * Input Parameter :   Customer Object 
	 * Return Value : CustomerDTO Object 
	 * Exception : CustomerServiceException
	 */
	@Override
	public CustomerDTO addCustomer(Customer customer) throws CustomerServiceException {
		Optional<Customer> addCustomerTemp = customerRepo.findById(customer.getUserId());
		if (addCustomerTemp.isEmpty()) {
			Customer addCustomer = customerRepo.save(customer);
			return CustomerUtil.convertToCustomerDto(addCustomer);
		} else {
			throw new CustomerServiceException("Customer already exists or invalid inputs");
		}

	}

	/*
	 * Description : This method remove Customer Details
	 * Input Parameter :  User ID 
	 * Return Value : CustomerDTO Object 
	 * Exception : CustomerServiceException
	 */
	@Override
	public CustomerDTO removeCustomer(long userId) throws CustomerServiceException {

		Optional<Customer> customerTemp = customerRepo.findById(userId);
		if (customerTemp.isEmpty()) {
			throw new CustomerServiceException("Customer does not exist");
		} else {
			customerRepo.deleteById(userId);
			if (customerTemp.isPresent()) {
				return CustomerUtil.convertToCustomerDto(customerTemp.get());
			} else {
				throw new CustomerServiceException("Customer is not present");
			}

		}

	}
	
	/*
	 * Description : This method updates Customer Details
	 * Input Parameter :  Customer Object  
	 * Return Value : CustomerDTO Object 
	 * Exception : CustomerServiceException
	 */
	@Override
	public CustomerDTO updateCustomer(Customer customer) throws CustomerServiceException {
		Optional<Customer> updateCustomerTemp = customerRepo.findById(customer.getUserId());
		if (updateCustomerTemp.isEmpty() ) {
			throw new CustomerServiceException("Customer not found or invalid inputs");
		} else {
			Customer updateCustomer = customerRepo.save(customer);
			return CustomerUtil.convertToCustomerDto(updateCustomer);
		}

	}
	
	/*
	 * Description : This method gets a Customer Detail
	 * Input Parameter :  User ID 
	 * Return Value : CustomerDTO Object 
	 * Exception : CustomerServiceException
	 */
	@Override
	public CustomerDTO getCustomer(long userId) throws CustomerServiceException {
		Optional<Customer> getCustomerTemp = customerRepo.findById(userId);
		if (getCustomerTemp.isEmpty()) {
			throw new CustomerServiceException("Customer does not exist");
		} else {
			Customer getCustomer = customerRepo.findById(userId).orElse(null);
			return CustomerUtil.convertToCustomerDto(getCustomer);

		}

	}
	
	/*
	 * Description : This method gets all Customer Details
	 * Return Value : List of CustomerDTO Objects 
	 * Exception : CustomerServiceException
	 */
	@Override
	public List<CustomerDTO> getAllCustomers() throws CustomerServiceException {
		List<Customer> getCustomer = new ArrayList<Customer>();
		getCustomer = customerRepo.findAll();
		if (getCustomer.isEmpty()) {
			throw new CustomerServiceException("Customers not found");
		} else {
			return CustomerUtil.convertToCustomerDtoList(getCustomer);
		}

	}

	public static boolean checkName(Customer customer) {
		boolean flag = true;
		if (customer.getName().length() < 3 || customer.getName().length() > 20 || customer.getName().isEmpty()) {
			flag = false;
		}
		return flag;
	}

	public static boolean checkContactNo(Customer customer) {
		boolean flag = true;
		if (customer.getContactNo().length() != 10 || customer.getContactNo().isEmpty()) {
			flag = false;
		}
		return flag;
	}

	public static boolean checkEmail(Customer customer) {
		boolean flag = true;
		if (customer.getEmail().length() < 8 || customer.getEmail().length() > 30 || customer.getEmail().isEmpty()) {
			flag = false;
		}
		return flag;
	}

}
