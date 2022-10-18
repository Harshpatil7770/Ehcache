package com.eh.cache.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.eh.cache.dao.ProductRepo;
import com.eh.cache.dto.ProductDTO;
import com.eh.cache.model.Product;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepo productRepo;

	@Override
	public Product addNewProduct(ProductDTO productDTO) {
		log.info("addNewProduct() called");
		Product product = new Product();
		product.setProductName(productDTO.getProductName());
		product.setPrice(productDTO.getPrice());
		product.setBrandName(productDTO.getBrandName());
		product.setCategoryName(productDTO.getCategoryName());
		return productRepo.save(product);
	}

	@Override
	@Cacheable(value =  "products")
	public List<Product> findAllProducts() {
		log.info("findAllProducts() called");
		List<Product> productLists = productRepo.findAll();
		return productLists;
	}

	@Override
	public Product findProductById(long productId) {
		log.info("findProductById() called");
		Product existingProduct = productRepo.findById(productId).orElse(null);
		return existingProduct;
	}

	@Override
	public Product findProductDetailsByProductName(String productName) {
		log.info("findProductDetailsByProductName() called");
		Product existingProduct = productRepo.findByProductName(productName).orElse(null);
		return existingProduct;
	}

}
