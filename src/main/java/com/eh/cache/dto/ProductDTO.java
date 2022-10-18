package com.eh.cache.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

	private long productId;

	private String productName;

	private double price;

	private String brandName;

	private String categoryName;
}
