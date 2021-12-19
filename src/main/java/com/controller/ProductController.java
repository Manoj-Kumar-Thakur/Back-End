package com.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.Product;
import com.model.ProductDTO;
import com.services.IProductService;

@RestController
@RequestMapping("/api/oss")
@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {
	
	final Logger LOGGER =	LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IProductService productService;

	@PostMapping("/addProduct")
	public ResponseEntity<ProductDTO> addProduct(@RequestBody Product product) {
		LOGGER.info("Add Product Details executed"); 
		ProductDTO resultProduct = productService.addProduct(product);
		return new ResponseEntity<ProductDTO>(resultProduct,HttpStatus.OK) ; 
		
	}

	@DeleteMapping("/deleteProduct/{productId}")
	public ResponseEntity<String> deleteProduct(@PathVariable long productId) {
		LOGGER.info("delete Product Details  executed"); 
		productService.removeProduct(productId);
		return new ResponseEntity<String>("Deleted Successfull",HttpStatus.OK) ;  
	}

	@PutMapping("/updateProduct")
	public ResponseEntity<ProductDTO> updateProduct(@RequestBody Product product) {
		LOGGER.info("Update Product Details executed"); 
		ProductDTO resultProduct = productService.updateProduct(product.getProductId(), product);
		return new ResponseEntity<ProductDTO>(resultProduct, HttpStatus.OK);
	}

	@GetMapping("/getProduct/{productId}")
	public ResponseEntity<ProductDTO> findProduct(@PathVariable long productId) {
		LOGGER.info("Get Product Details By Id executed"); 
		ProductDTO resultProduct = productService.getProduct(productId);
		return new ResponseEntity<ProductDTO>(resultProduct, HttpStatus.OK);
	}

	@GetMapping("/getAllProduct")
	public List<ProductDTO> getProducts() {
		LOGGER.info("Get ALL Product Details executed"); 
		return productService.getAllProduct();
	}

	@GetMapping("/getProductsByName/{productName}")
	public List<ProductDTO> getProductsByName(@PathVariable String productName) {
		LOGGER.info("Get Product Details By Name executed"); 
		return productService.findByProductName(productName);
	}

	@GetMapping("/getProductsBySize/{size}")
	public List<ProductDTO> getProductsBySize(@PathVariable int size) {
		LOGGER.info("Get Product Details By Size executed");
		return productService.findBySize(size);
	}

	@GetMapping("/getProductsByColor/{color}")
	public List<ProductDTO> getProductsByColor(@PathVariable String color) {
		LOGGER.info("Get Product Details By Color executed");
		return productService.findByColor(color);
	}

	@GetMapping("/getProductsByPrice/{priceAfterDiscount}")
	public List<ProductDTO> getProductsByPrice(@PathVariable double priceAfterDiscount) {
		LOGGER.info("Get Product Details By Price executed");
		return productService.findByPriceAfterDiscount(priceAfterDiscount);
	}
}