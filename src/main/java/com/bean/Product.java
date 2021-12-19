package com.bean;


import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "products")
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "productid")
	private long productId;

	@Column(name = "productname", nullable = false, length = 20)
	@NotBlank(message = "ProductName should not be blank")
	private String productName;

	@Column(name = "category", nullable = false, length = 25)
	@NotBlank(message = "Category should not be blank")
	private String category;

	@Column(name = "description")
	private String description;

	@Column(name = "brand")
	private String brand;

	@Column(name = "color", nullable = false)
	@NotBlank(message = "Color should not be blank")
	private String color;

	@Column(name = "size", nullable = false)
	@NotNull(message = "Size should not be blank")
	private int size;

	@Column(name = "mrp")
	private int mrp;

	@Column(name = "discount")
	private int discount;

	@Column(name = "priceafterdiscount")
	private double priceAfterDiscount;

	@Column(name = "instock")
	private boolean inStock;

	@Column(name = "estimateddelivery")
	private LocalDate estimatedDelivery;

	@ManyToOne(targetEntity = Cart.class,  cascade= CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "cartid", referencedColumnName = "cartid", nullable = false)
	private Cart cart;

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Product() {

		super();
	}

	public Product(long productId, String productName, String category, String description, String brand, String color,
			int size, int mrp, int discount, double priceAfterDiscount, boolean inStock, LocalDate estimatedDelivery,
			long cartid, String imageName, String cartProductName, int quantity, double price, double total) {
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
	
	public Product(long productId,String productName, String category, String description, String brand, String color,
			int size, int mrp, int discount, double priceAfterDiscount,
			boolean inStock, LocalDate estimatedDelivery, Cart cart) 
	{
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
		this.cart = cart;
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
		return "Product [productId=" + productId + ", productName=" + productName + ", category=" + category
				+ ", description=" + description + ", brand=" + brand + ", color=" + color + ", size=" + size + ", mrp="
				+ mrp + ", discount=" + discount + ", priceAfterDiscount=" + priceAfterDiscount + ", inStock=" + inStock
				+ ", estimatedDelivery=" + estimatedDelivery + ", cart=" + cart + "]";
	}
    
	public Product(long productId)
	{
		this.productId=productId;
	}

}

