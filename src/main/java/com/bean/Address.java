
package com.bean;

import java.io.Serializable;

import javax.persistence.Column;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="address")
public class Address implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "addressId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int addressId;
	
	@Column(name="doorno",nullable=false)
	@NotBlank(message="DoorNo should not be blank")
	private String doorNo;
	
	@Column(name="street",length=20,nullable=false)
	@NotBlank(message="Street should not be blank")
	private String street;
	
	@Column(name="area",length=20,nullable=false)
	@NotBlank(message="Area should not be blank")
	private String area;
	
	@Column(name="city",length=20,nullable=false)
	@NotBlank(message="City should not be blank")
	private String city;
	
	@Column(name="state",length=20,nullable=false)
	@NotBlank(message="State should not be blank")
	private String state;
	
	@Column(name="pincode",length=6,nullable=false)
	@NotNull(message="PinCode should not be blank")
	private int pinCode;

	public String getDoorNo() {
		return doorNo;
	}

	public void setDoorNo(String doorNo) {
		this.doorNo = doorNo;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPinCode() {
		return pinCode;
	}

	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}

	public int getAddressId() {
		return addressId;
	}

	public Address(String doorNo, String street, String area, String city, String state,int pinCode) {
		super();
		this.doorNo = doorNo;
		this.street = street;
		this.area = area;
		this.city = city;
		this.state = state;
		this.pinCode = pinCode;
	}

	
	public Address(int addressId, String doorNo, String street, String area, String city, String state,int pinCode) 
	{
		super();
		this.addressId = addressId;
		this.doorNo = doorNo;
		this.street = street;
		this.area = area;
		this.city = city;
		this.state = state;
		this.pinCode = pinCode;
	}
	
	public Address()
	{

		super();
	}

	
	@Override
	public String toString() {
		return "Address [doorNo=" + doorNo + ", street=" + street + ", area=" + area + ", city=" + city + ", state="
				+ state + ", pinCode=" + pinCode + "]";
	}


}