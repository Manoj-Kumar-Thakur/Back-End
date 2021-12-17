package com.capg.onlinesportsshopee.service;

import java.util.List;


import com.capg.onlinesportsshopee.bean.Product;

import com.capg.onlinesportsshopee.model.ProductDTO;
/* Author : AAYUSHI CHANSORIYA
 * Version : 1.0
 * Date : 02-04-2021
 * Description : This is Product Service Interface
 */
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