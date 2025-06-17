package com.revtech.microservices.product.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.testcontainers.containers.MongoDBContainer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revtech.microservices.product.dto.ProductRequest;
import com.revtech.microservices.product.model.Product;
import com.revtech.microservices.product.service.ProductService;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@AutoConfigureMockMvc
public class ProductControllerIntegrationTest {
	
	private ProductService productService;
	
	private  MockMvc mockMvc;
	
	private ObjectMapper objectMapper;
	
	@ServiceConnection
	static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:7.0.5");
	
	@Autowired
	public ProductControllerIntegrationTest(MockMvc mockMvc, ProductService productService) {
		this.mockMvc = mockMvc;
		this.productService = productService;
		this.objectMapper = new ObjectMapper();
	}
	
	@Test
	public void testThatCreateAuthorSuccessfullyReturnsSavedAuthor() throws Exception{
		mongoDBContainer.start();
		Product product = TestDataUtil.createTestProduct();
		
		ProductRequest productRequest = new ProductRequest(null, product.getName(), product.getDescription(), product.getPrice());
		String jsonProductRequest = objectMapper.writeValueAsString(productRequest);
		
		mockMvc.perform(
				MockMvcRequestBuilders.post("/api/product")
				.contentType(MediaType.APPLICATION_JSON)
				.content(jsonProductRequest)
		).andExpect(
				MockMvcResultMatchers.jsonPath("$.id").exists()
		).andExpect(
				MockMvcResultMatchers.jsonPath("$.name").value(product.getName())
		).andExpect(
				MockMvcResultMatchers.jsonPath("$.description").value(product.getDescription())
		).andExpect(
				MockMvcResultMatchers.jsonPath("$.price").value(product.getPrice())
		);
	}
}
