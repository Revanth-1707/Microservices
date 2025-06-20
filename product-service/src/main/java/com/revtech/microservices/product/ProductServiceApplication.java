package com.revtech.microservices.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
public class ProductServiceApplication {

	public static void main(String[] args) {
		Dotenv dotenv = Dotenv.load(); // loads .env file
        System.setProperty("DB_USERNAME", dotenv.get("DB_USERNAME"));
        System.setProperty("DB_PASSWORD", dotenv.get("DB_PASSWORD"));
		SpringApplication.run(ProductServiceApplication.class, args);
	}
}
