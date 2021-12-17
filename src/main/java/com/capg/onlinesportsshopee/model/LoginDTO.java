package com.capg.onlinesportsshopee.model;

import org.springframework.stereotype.Component;

import com.capg.onlinesportsshopee.bean.User;

/*
 * Author : SAI MADHU BHAVANA A
 * Version : 1.0
 * Date : 06-04-2021
 * Description : This is LoginDTO Class
*/
@Component
public class LoginDTO {

	private int loginId;
	private User user;

	public LoginDTO() {
		super();
	}

	public LoginDTO(int loginId, User user) {
		super();
		this.loginId = loginId;
		this.user = user;
	}

	public int getLoginId() {
		return loginId;
	}

	public void setLoginId(int loginId) {
		this.loginId = loginId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "LoginDTO [loginId=" + loginId + ", user=" + user + "]";
	}
	
}