package com.revtech.microservices.product.model;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Document(value = "product")
public class Product {
	
	@Id
	private String id;
	private String name;
	private String description;
	private String skuCode;
	private BigDecimal price;

}
