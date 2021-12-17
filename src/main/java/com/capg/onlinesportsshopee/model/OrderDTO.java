
package com.capg.onlinesportsshopee.model;

import org.springframework.stereotype.Component;
import com.capg.onlinesportsshopee.bean.Customer;
import java.time.LocalDate;
import com.capg.onlinesportsshopee.bean.Payment;
import com.capg.onlinesportsshopee.bean.Product;


/*
 * Author      : JISHNA K
 * Version     : 1.0
 * Date        : 05-04-2021
 * Description : This is OrderDTO class
*/
@Component
public class OrderDTO  {
	private long orderId;
	private double amount;
	private String billingDate;
	private Customer customer;
	private Product product;
	private Payment payment;
	
	public OrderDTO() {
		super();
		
	}
	public OrderDTO(long orderId, double amount, String billingDate,long userId,String name, String email, String contactNo, String dob,String doorNo, String street, String area, String city, String state, int pinCode,
			long productId, String productName, String category, String description, String brand, String color,
			int size, int mrp, int discount, double priceAfterDiscount, boolean inStock, LocalDate estimatedDelivery,
			long cartid, String imageName, String cartProductName, int quantity, double price, double total,long paymentId,String type, String status,
			long id,String cardName, String cardNumber, LocalDate cardExpiry, int cvv) {
		super();
		this. orderId= orderId;
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
		return "OrderDTO [orderId=" + orderId + ", amount=" + amount + ", billingDate=" + billingDate + ", customer="
				+ customer + ", product=" + product + ", payment=" + payment + "]";
	}
    
}