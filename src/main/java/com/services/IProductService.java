package com.services;

import java.util.List;

import com.bean.Product;
import com.model.ProductDTO;

public interface IProductService {
	public ProductDTO addProduct(Product product);
	public void removeProduct(long id);
	public ProductDTO updateProduct(long id, Product product);
	public ProductDTO getProduct(long productId);
	public List<ProductDTO> getAllProduct();
	public List<ProductDTO> findByPriceAfterDiscount(double priceAfterDiscount);
	public List<ProductDTO> findByProductName(String productName);
	public List<ProductDTO> findByColor(String color);
	public List<ProductDTO> findBySize(int size);

}