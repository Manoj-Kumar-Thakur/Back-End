package com;

import java.util.ArrayList;
import java.util.List;

//import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
//import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.bean.Customer;
import com.exceptions.CustomerNotFoundException;
//import com.exceptions.InvalidCustomerIdException;
import com.repo.ICustomerRepository;
import com.services.CustomerServiceImpl;
import com.services.ICustomerService;

import junit.framework.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CustomerServiceImpl.class)
class CustomerServiceImplTest {
//
		@MockBean
		ICustomerRepository iCustomerRepository;
		
		@Autowired
		ICustomerService iCustomerService;
		
		@Test
		void testaddCustomer01() throws CustomerNotFoundException {
			Customer customerentity = new Customer();
			customerentity.setUserId((long)123);
	        customerentity.setName("Tom");
	        customerentity.setEmail("tom@gmail.com");
	        customerentity.setContactNo("9567893321");
	        //customerentity.setDob(LocalDate.parse("1997-10-12"));
			
			Mockito.when(iCustomerRepository.save(customerentity)).thenReturn(customerentity);
	        Assert.assertNotNull(customerentity);
		}
		
		
		
		@Test
		void testUpdateCustomer01() throws CustomerNotFoundException {
			Customer customerentity = new Customer();
			customerentity.setUserId((long)125);
	        customerentity.setName("nobita");
	        customerentity.setEmail("nobita@gmail.com");
	        customerentity.setContactNo("9564237891");
	        //customerentity.setDoB(LocalDate.parse("1997-01-31"));
	        
	        iCustomerRepository.save(customerentity);
	        Assert.assertNotNull(customerentity);
		}
		
		
		@Test
		void testgetAllCustomers01() {
			Customer customerentity1 = new Customer();
			customerentity1.setUserId((long)125);
	        customerentity1.setName("nobita");
	        customerentity1.setEmail("nobita@gmail.com");
	        customerentity1.setContactNo("9564237891");
	       // customerentity1.setDoB(LocalDate.parse("1997-01-31"));
	        
	        Customer customerentity2 = new Customer();
			customerentity2.setUserId((long)125);
	        customerentity2.setName("nobita");
	        customerentity2.setEmail("nobita@gmail.com");
	        customerentity2.setContactNo("9564237891");
	       // customerentity2.setDoB(LocalDate.parse("1997-01-31"));
	        
	        List<Customer> customerlist = new ArrayList();
	        customerlist.add(customerentity1);
	        customerlist.add(customerentity2);
	        Mockito.when(iCustomerRepository.findAll()).thenReturn(customerlist);
		}

}
//