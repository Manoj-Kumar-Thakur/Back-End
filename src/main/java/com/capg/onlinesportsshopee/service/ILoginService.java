package com.capg.onlinesportsshopee.service;

import com.capg.onlinesportsshopee.bean.User;
import com.capg.onlinesportsshopee.exceptions.LoginNotFoundException;
import com.capg.onlinesportsshopee.exceptions.UserNotFoundException;
/*
 * Author : SAI MADHU BHAVANA A
 * Version : 1.0
 * Date : 06-04-2021
 * Description : This is Login Service Interface Layer that provides Interface services to Log-in 
*/
public interface ILoginService {
	
	public boolean Login(User user) throws LoginNotFoundException, UserNotFoundException;

}
