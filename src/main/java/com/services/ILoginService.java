package com.services;

import com.bean.User;
import com.exceptions.LoginNotFoundException;
import com.exceptions.UserNotFoundException;

public interface ILoginService {
	
	public boolean Login(User user) throws LoginNotFoundException, UserNotFoundException;

}
