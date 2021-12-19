package com.util;

import java.util.ArrayList;
import java.util.List;

import com.bean.Product;
import com.model.ProductDTO;


public class ProductUtil {

	public static List<ProductDTO> convertToProductDtoList(List<Product> list) {
		List<ProductDTO> ProductDtoList = new ArrayList<ProductDTO>();
		for (Product product : list)
			ProductDtoList.add(convertToProductDto(product));
		return ProductDtoList;
	}

	public static Product convertToProduct(ProductDTO productDto) {
		Product product = new Product();

		product.setProductId(productDto.getProductId());
		product.setProductName(productDto.getProductName());
		product.setCategory(productDto.getCategory());
		product.setDescription(productDto.getDescription());
		product.setBrand(productDto.getBrand());
		product.setColor(productDto.getColor());
		product.setSize(productDto.getSize());
		product.setMrp(productDto.getMrp());
		product.setDiscount(productDto.getDiscount());
		product.setPriceAfterDiscount(productDto.getPriceAfterDiscount());
		product.setInStock(productDto.isInStock());
		product.setEstimatedDelivery(productDto.getEstimatedDelivery());
		product.setCart(productDto.getCart());
		return product;
	}

	public static ProductDTO convertToProductDto(Product product) {
		ProductDTO productDto = new ProductDTO();

		productDto.setProductId(product.getProductId());
		productDto.setProductName(product.getProductName());
		productDto.setCategory(product.getCategory());
		productDto.setDescription(product.getDescription());
		productDto.setBrand(product.getBrand());
		productDto.setColor(product.getColor());
		productDto.setSize(product.getSize());
		productDto.setMrp(product.getMrp());
		productDto.setDiscount(product.getDiscount());
		productDto.setPriceAfterDiscount(product.getPriceAfterDiscount());
		productDto.setInStock(product.isInStock());
		productDto.setEstimatedDelivery(product.getEstimatedDelivery());
		productDto.setCart(product.getCart());

		return productDto;
	}

}
