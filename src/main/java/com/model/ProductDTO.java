package com.model;

import java.time.LocalDate;


import org.springframework.stereotype.Component;

import com.bean.Cart;

@Component
public class ProductDTO {
	private long productId;
	private String productName;
	private String category;
	private String description;
	private String brand;
	private String color;
	private int size;
	private int mrp;
	private int discount;
	private double priceAfterDiscount;
	private boolean inStock;
	private LocalDate estimatedDelivery;
	private Cart cart;

	public ProductDTO() {
		super();

	}

	public ProductDTO(long productId, String productName, String category, String description, String brand,
			String color, int size, int mrp, int discount, double priceAfterDiscount, boolean inStock,
			LocalDate estimatedDelivery ,long cartid, String imageName, String cartProductName, int quantity, double price, 
			double total) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.category = category;
		this.description = description;
		this.brand = brand;
		this.color = color;
		this.size = size;
		this.mrp = mrp;
		this.discount = discount;
		this.priceAfterDiscount = priceAfterDiscount;
		this.inStock = inStock;
		this.estimatedDelivery = estimatedDelivery;
		this.cart = new Cart(cartid,imageName , cartProductName,quantity,price,total);

	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getMrp() {
		return mrp;
	}

	public void setMrp(int mrp) {
		this.mrp = mrp;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public double getPriceAfterDiscount() {
		return priceAfterDiscount;
	}

	public void setPriceAfterDiscount(double priceAfterDiscount) {
		this.priceAfterDiscount = priceAfterDiscount;
	}

	public boolean isInStock() {
		return inStock;
	}

	public void setInStock(boolean inStock) {
		this.inStock = inStock;
	}

	public LocalDate getEstimatedDelivery() {
		return estimatedDelivery;
	}

	public void setEstimatedDelivery(LocalDate estimatedDelivery) {
		this.estimatedDelivery = estimatedDelivery;
	}

	

	@Override
	public String toString() {
		return "ProductDTO [productId=" + productId + ", productName=" + productName + ", category=" + category
				+ ", description=" + description + ", brand=" + brand + ", color=" + color + ", size=" + size + ", mrp="
				+ mrp + ", discount=" + discount + ", priceAfterDiscount=" + priceAfterDiscount + ", inStock=" + inStock
				+ ", estimatedDelivery=" + estimatedDelivery + ", cart=" + cart + "]";
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

}

