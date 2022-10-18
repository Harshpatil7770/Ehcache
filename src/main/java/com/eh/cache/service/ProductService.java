package com.eh.cache.service;

import java.util.List;

import com.eh.cache.dto.ProductDTO;
import com.eh.cache.model.Product;

public interface ProductService {

	Product addNewProduct(ProductDTO productDTO);
	
	List<Product> findAllProducts();
	
	Product findProductById(long productId);
	
	Product findProductDetailsByProductName(String productName);
}
