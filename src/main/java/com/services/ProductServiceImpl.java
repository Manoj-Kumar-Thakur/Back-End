package com.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Product;
import com.exceptions.ProductServiceException;
import com.model.ProductDTO;
import com.repo.IProductRepository;
import com.util.ProductUtil;

/*
Description : This is Product Service Layer that provides services to add new products, 
              update the existing product details, remove existing product details,
              get existing product details and get all existing product details.
*/

@Service
public class ProductServiceImpl implements IProductService {

	 @Autowired
	 private IProductRepository repo;
	

	 /*
		 * Description : This method adds Product Details 
		 * Input Parameter : Product
		 * Object Return Value : ProductDTO Object 
		 * Exception : ProductServiceException
		 */ 
	@Override
	public ProductDTO addProduct(Product product) throws ProductServiceException {
		Optional<Product> product1= repo.findById(product.getProductId());
		if (product1.isEmpty()) {
			Product addProduct =  repo.save(product);
			return ProductUtil.convertToProductDto(addProduct);
		} else {
			throw new ProductServiceException("Product already exists");
		}
	}

	/*
	 * Description : This method removes Product Details 
	 * Input Parameter : Product
	 * Object Return Value : ProductDTO Object 
	 * Exception : ProductServiceException
	 */
	@Override
	public void removeProduct(long productId) throws ProductServiceException {
	Optional<Product> product1=repo.findById(productId);
	if(!product1.isEmpty()) {
		if(product1.isPresent())
		{
			repo.delete(product1.get());
		}
	}
	else 
		throw new ProductServiceException("Product does not exist to delete");
		
}

	/*
	 * Description : This method updates Product Details 
	 * Input Parameter : Product
	 * Object Return Value : ProductDTO Object 
	 * Exception : ProductServiceException
	 */
	@Override
	public ProductDTO updateProduct(long productId, Product product) throws ProductServiceException {
		Optional<Product> product1=repo.findById(productId);
		if(product1.isEmpty()) {
			throw new ProductServiceException("Product not found");
		}
		else
		{
			Product updateProduct = repo.save(product);
			return ProductUtil.convertToProductDto(updateProduct);
		}
			
		
	}


	/*
	 * Description : This method finds product byId
	 * Input Parameter : ProductId
	 * Object Return Value : ProductDTO Object 
	 * Exception : ProductServiceException
	 */
	@Override
	public ProductDTO getProduct(long productId){
		Optional<Product> product=repo.findById(productId);
		if(!product.isEmpty()) {
			Product getProduct = repo.findById(productId).orElse(null);
			return ProductUtil.convertToProductDto(getProduct);
			
		}
		else
		{
			throw new ProductServiceException("Given product id does not exists");
		}
	
		
	}


	/*
	 * Description : This method gets all Product Details 
	 * Object Return Value :List of ProductDTO Object 
	 * Exception : ProductServiceException
	 */
	@Override
	public List<ProductDTO> getAllProduct() throws ProductServiceException {
		List<Product> productList= repo.findAll();
		if(productList.isEmpty()) {
			throw new ProductServiceException("Products not found");
		}
		return ProductUtil.convertToProductDtoList(productList);
	}


	

	@Override
	public List<ProductDTO> findByProductName(String productName) throws ProductServiceException {
	
	List<Product> productList= repo.findByProductName(productName);
	if(productList.isEmpty()) {
		throw new ProductServiceException("Products not found");
	}
	return ProductUtil.convertToProductDtoList(productList);
}


	@Override
	public List<ProductDTO> findBySize(int size) throws ProductServiceException {
		List<Product> productList= repo.findBySize(size);
		if(productList.isEmpty()) {
			throw new ProductServiceException("Products with required sizes not found");
		}
		return ProductUtil.convertToProductDtoList(productList);
	}


	@Override
	public List<ProductDTO> findByPriceAfterDiscount(double priceAfterDiscount ) throws ProductServiceException {
	List<Product> productList= repo.findByPriceAfterDiscount(priceAfterDiscount);
	if(productList.isEmpty()) {
		throw new ProductServiceException("Products with mentioed price not found");
	}
	return ProductUtil.convertToProductDtoList(productList);
}



	@Override
	public List<ProductDTO> findByColor(String color) throws ProductServiceException {
		List<Product> productList= repo.findByColor(color);
		if(productList.isEmpty()) {
			throw new ProductServiceException("Products with mentioned color not found");
		}
		return ProductUtil.convertToProductDtoList(productList);

	}

}

