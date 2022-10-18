package com.eh.cache.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eh.cache.dto.ProductDTO;
import com.eh.cache.model.Product;
import com.eh.cache.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/products")
@Slf4j
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@PostMapping("/save")
    public Product addNewProduct(@RequestBody ProductDTO productDTO) {
		log.info("addNewProduct() called");
    	return productService.addNewProduct(productDTO);
    }
	
	@GetMapping("/findAll")
    public List<Product> findAllProducts(){
		log.info("findAllProducts() called");
    	return productService.findAllProducts();
	}
	
	@GetMapping("/find/{productId}")
    public Product findProductById(@PathVariable long productId) {
		log.info("findProductById() called");
    	return productService.findProductById(productId);
	}
	
	@GetMapping("/find/")
    public Product findProductDetailsByProductName(@RequestParam String productName) {
		log.info("findProductDetailsByProductName() called");
    	return productService.findProductDetailsByProductName(productName);
	}
}
