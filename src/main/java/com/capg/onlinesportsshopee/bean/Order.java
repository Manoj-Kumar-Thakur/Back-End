package com.capg.onlinesportsshopee.bean;
import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

/*
 * Author      : JISHNA K
 * Version     : 1.0
 * Date        : 05-04-2021
 * Description : This is Order Entity class
*/


@Entity
@Table(name="orders")
public class Order implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name= "order_id",nullable=false)
	@NotBlank(message="Order Id should not be blank")
	private long orderId;
	
	@Column(name= "amount",nullable=false)
	@NotBlank(message="Amount should not be blank")
	private double amount;
	


	//@Temporal(TemporalType.DATE)
	@Column(name = "billing_date")
	@NotBlank(message="Billing Date should not be blank")
	private String billingDate;
	

	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userid", referencedColumnName = "userid",nullable = false)
	private Customer customer;
	
	@OneToOne(fetch = FetchType.LAZY)
	private Product product;

	@OneToOne(fetch = FetchType.LAZY)
	private Payment payment;


	public Order() {
		super();
	}

	public Order(long orderId, double amount, String billingDate,long userId) {

		super();
		this.orderId= orderId;
		this.amount = amount;
		this.billingDate = billingDate;
		this.customer= new Customer(userId);
	}


	public Order(long orderId, double amount, String billingDate,long userId,String name, String email, String contactNo, String dob,String doorNo, String street, String area, String city, String state, int pinCode,
			long productId, String productName, String category, String description, String brand, String color,
			int size, int mrp, int discount, double priceAfterDiscount, boolean inStock, LocalDate estimatedDelivery,
			long cartid, String imageName, String cartProductName, int quantity, double price, double total,long paymentId,String type, String status,
			long id,String cardName, String cardNumber, LocalDate cardExpiry, int cvv) {

		super();
		this.orderId= orderId;
		this.amount = amount;
		this.billingDate = billingDate;
		this.customer= new Customer (userId,name,email,contactNo,dob, doorNo,street,area, city, state, pinCode );
		this.product = new Product( productId,productName,category, description,brand,color,
			size, mrp, discount, priceAfterDiscount, inStock,  estimatedDelivery,
			cartid,imageName, cartProductName,  quantity, price, total);
		this.payment=new Payment(paymentId,type,  status,cardName, id, cardNumber, cardExpiry, cvv);

	}
	
	

	public long getOrderId() {
		return orderId;
	}
	
	
	
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getBillingDate() {
		return billingDate;
	}
	public void setBillingDate(String billingDate) {
		this.billingDate = billingDate;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Payment getPayment() {
		return payment;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", amount=" + amount + ", billingDate=" + billingDate + ", customer="
				+ customer + ", product=" + product + ", payment=" + payment + "]";
	}

	public Order(@NotBlank(message = "Order Id should not be blank") long orderId,
			@NotBlank(message = "Amount should not be blank") double amount,
			@NotBlank(message = "Billing Date should not be blank") String billingDate, Customer customer,
			Product product, Payment payment) {
		super();
		this.orderId = orderId;
		this.amount = amount;
		this.billingDate = billingDate;
		this.customer = customer;
		this.product = product;
		this.payment = payment;
	}
	


}
