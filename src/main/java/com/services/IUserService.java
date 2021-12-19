
package com.services;


import java.util.List;

import com.bean.User;
import com.exceptions.UserNotFoundException;
import com.exceptions.UserServiceException;
import com.model.UserDTO;

public interface IUserService {

	public UserDTO addUser(User user);

	public UserDTO updateUser(User user);

	public UserDTO deleteUser(long userId) throws UserNotFoundException;

	public UserDTO getId(long userId);

	public List<UserDTO> getAllUserDetails() throws UserServiceException;


}




