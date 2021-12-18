package com.capg.onlinesportsshopee.bean;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
/* Author : AAYUSHI CHANSORIYA
 * Version : 1.0
 * Date : 02-04-2021
 * Description : This is Cart Entity
 */
@Entity
@Table(name="cart")
public class Cart implements Serializable{
	
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cartid" )
	 private long cartid;
	 
	@Column(name="imageName",nullable = false)
	private String imageName;
	
	@Column(name="cartProductName",nullable = false)
	@NotBlank(message="CartProductName should not be blank")
	private String cartProductName;
	
	@Column(name="quantity",nullable = false)
	@NotNull(message="Quantity should be specified")
	 private int quantity;
	
	@Column(name="price",nullable = false)
	 private double price;
	

	@Column(name = "total",nullable = false)
	 private double total;
	
	
	
	public Cart() {
		
	}
	
	
	
	public Cart(long cartid, String imageName, String cartProductName, int quantity, double price, double total) {
		super();
		this.cartid = cartid;
		this.imageName = imageName;
		this.cartProductName = cartProductName;
		this.quantity = quantity;
		this.price = price;
		this.total = total;
	}



	public long getCartId() {
		return cartid;
	}
	public void setCartId(long cartid) {
		this.cartid = cartid;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public String getProductName() {
		return cartProductName;
	}
	public void setProductName(String cartProductName) {
		this.cartProductName = cartProductName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	@Override
	public String toString() {
		return "Cart [cartId=" + cartid + ", imageName=" + imageName + ", cartProductName=" + cartProductName + ", quantity="
				+ quantity + ", price=" + price + ", total=" + total + "]";
	}
	 
}