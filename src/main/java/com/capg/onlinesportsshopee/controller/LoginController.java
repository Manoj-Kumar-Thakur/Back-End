package com.capg.onlinesportsshopee.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.onlinesportsshopee.bean.User;
import com.capg.onlinesportsshopee.exceptions.LoginNotFoundException;
import com.capg.onlinesportsshopee.exceptions.UserNotFoundException;
import com.capg.onlinesportsshopee.service.ILoginService;

/*
 * Author : SAI MADHU BHAVANA A
 * Version : 1.0
 * Date : 06-04-2021
 * Description : This is Login Controller
*/

@RestController
@RequestMapping("/api/oss")
@CrossOrigin(origins = "http://localhost:3000")
public class LoginController {
	

		@Autowired
		private ILoginService loginService;
		
		final Logger LOGGER =	LoggerFactory.getLogger(this.getClass());
		
		@PatchMapping("/validatelogin")
		public ResponseEntity<String> validateLogin(@RequestBody User user) throws LoginNotFoundException,UserNotFoundException
		{
			LOGGER.info("Validate Login is executed");
			ResponseEntity<String> loginResponse = new ResponseEntity<String>("User Id and Password Does Not Match", HttpStatus.ACCEPTED);
			if(!loginService.Login(user))
				//throw new LoginNotFoundException("Login id  and Password Does not match");
				loginResponse = new ResponseEntity<String>("Login Failed", HttpStatus.ACCEPTED);
			   
			else
				loginResponse = new ResponseEntity<String>("Login Successful!", HttpStatus.ACCEPTED);
			return loginResponse;
		}
		
}