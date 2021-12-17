package com.capg.onlinesportsshopee.util;

import java.util.ArrayList;
import java.util.List;

import com.capg.onlinesportsshopee.bean.User;
import com.capg.onlinesportsshopee.model.UserDTO;

/*
 * Author : SAI MADHU BHAVANA A
 * Version : 1.0
 * Date : 04-04-2021
 * Description : This is UserUtil Class
*/
public class UserUtil {

	public static List<UserDTO> convertToUserDtoList(List<User> list) {
		List<UserDTO> UserDTOList = new ArrayList<UserDTO>();
		for (User user : list)
			UserDTOList.add(convertToUserDto(user));
		return UserDTOList;
	}

	public static User convertToUser(UserDTO userDTO) {
		User user = new User();

		user.setUserId(user.getUserId());
		user.setPassword(user.getPassword());
		user.setRole(user.getRole());

		return user;
	}

	public static UserDTO convertToUserDto(User user) {
		UserDTO userDTO = new UserDTO();

		userDTO.setUserId(user.getUserId());

		userDTO.setusername(user.getUsername());
		userDTO.setPassword(user.getPassword());
		userDTO.setRole(user.getRole());

		return userDTO;
	}

}