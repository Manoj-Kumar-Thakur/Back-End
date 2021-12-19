package com.model;

import org.springframework.stereotype.Component;

import com.bean.Address;

@Component
public class CustomerDTO 
{
	private long userId;
	private String name;
	private String email;
	private String contactNo;
	private  String dob;
	private Address address;

	
	
	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) 
	{
		this.name = name;
	}
	
	public String getEmail() 
	{
		return email;
	}
	
	public void setEmail(String email) 
	{
		this.email = email;
	}
	
	public String getContactNo() 
	{
		return contactNo;
	}
	
	public void setContactNo(String contactNo) 
	{
		this.contactNo = contactNo;
	}
	
	public String getDob() 
	{
		return dob;
	}
	
	public void setDob(String dob) 
	{
		this.dob = dob;
	}
	
	public Address getAddress() 
	{
		return address;
	}
	
	public void setAddress(Address address) 
	{
		this.address = address;
	}
	
	public CustomerDTO()
	{
		super();
	}
	
	public CustomerDTO(long userId, String name, String email, String contactNo, String dob, Address address) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.contactNo = contactNo;
		this.dob = dob;
		this.address = address;
	}

	public CustomerDTO( String name, String email, String contactNo, String dob, Address address) {
		super();
		this.name = name;
		this.email = email;
		this.contactNo = contactNo;
		this.dob = dob;
		this.address = address;
	}
	
	
	public CustomerDTO(long userId) {
		this.userId=userId;
	}

	@Override
	public String toString() {
		return "CustomerDTO [userId=" + userId + ", name=" + name + ", email=" + email + ", contactNo="
				+ contactNo + ", dob=" + dob + ", address=" + address + "]";
	}

	
}


