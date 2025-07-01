package com.revtech.microservices.product.controller;

import java.math.BigDecimal;



import com.revtech.microservices.product.model.Product;

public class TestDataUtil {
	
	public static Product createTestProduct() {
		return Product.builder()
				.name("iphone16")
				.description("SmartPhone")
				.skuCode("iphone")
				.price(new BigDecimal(1000))
				.build();
	}
}
