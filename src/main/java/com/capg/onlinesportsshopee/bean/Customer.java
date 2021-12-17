
package com.capg.onlinesportsshopee.bean;

import java.io.Serializable;



import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

/*
 * Author : THEEPAK PRAKASH P
 * Version : 1.0
 * Date : 01-04-2021
 * Description : This is Customer Entity 
*/
@Entity
@Table(name = "customers")
public class Customer implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "userid")
	private long userId;

	@Column(name = "name",nullable=false,length=20)
	@NotBlank(message="Name should not be blank")
	private String name;

	@Column(name = "email",unique=true,nullable=false, length = 25)
	@NotBlank(message="EmailId should not be blank")
	private String email;

	@Column(name = "contactno",unique=true,nullable=false, length = 10)
	@NotBlank(message="ContactNo should not be blank")
	private String contactNo;

	@Column(name = "dob",nullable=false)
	@NotBlank(message="Date of Birth should not be blank")
	private String dob;

	@OneToOne(cascade = {CascadeType.ALL})
	private Address address;
	






	public Customer() {
		super();
	}

	public Customer(long userId,  String name,String email, String contactNo, String dob, Address address) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.contactNo = contactNo;
		this.dob = dob;
		this.address = address;
	}
	
	public Customer(long userId, String name, String email,String contactNo,String dob, String doorNo, String street, String area, String city, String state, int pinCode) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.contactNo = contactNo;
		this.dob = dob;
		this.address = new Address(doorNo,street,area,city,state,pinCode);
	}

	public Customer( String name, String email,String contactNo,String dob, String doorNo, String street, String area, String city, String state, int pinCode) {
		super();
		this.name = name;
		this.email = email;
		this.contactNo = contactNo;
		this.dob = dob;
		this.address = new Address(doorNo,street,area,city,state,pinCode);
	}
	

	public Customer(long userId) {
		this.userId=userId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Customer [userId=" + userId + ", name=" + name + ", email=" + email + ", contactNo=" + contactNo+ ", "+ "dob=" + dob + ", address=" + address + "]";
	}

	


}