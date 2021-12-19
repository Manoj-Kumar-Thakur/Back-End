package com.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.User;
import com.exceptions.LoginNotFoundException;
import com.exceptions.UserNotFoundException;



@Service
public class LoginServiceImpl implements ILoginService {

	
	@Autowired
	private UserServiceImpl userService;

	@Override
	public boolean Login(User user) throws LoginNotFoundException,UserNotFoundException {
		boolean flag = false;
		if(user == null)
			//throw new LoginNotFoundException("User Details cannot be Empty");
			flag= false;
		else if(!userService.checkUser(user.getUserId(), user.getUsername(), user.getPassword()))
			//throw new LoginNotFoundException("Invalid UserName or Password");
			flag= false;
		else
			flag = true;
		return flag;
	}

}