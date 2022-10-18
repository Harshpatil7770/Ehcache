package com.eh.cache.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eh.cache.model.Product;
@Repository
public interface ProductRepo extends JpaRepository<Product, Long>{

	Optional<Product> findByProductName(String productName);

}
