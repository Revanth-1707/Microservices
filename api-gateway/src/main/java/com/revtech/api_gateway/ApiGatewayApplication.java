package com.revtech.api_gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
public class ApiGatewayApplication {

	public static void main(String[] args) {
		Dotenv dotenv = Dotenv.load(); // loads .env file
        System.setProperty("DB_USERNAME", dotenv.get("DB_USERNAME"));
        System.setProperty("DB_PASSWORD", dotenv.get("DB_PASSWORD"));
        System.setProperty("KEYCLOAK_ADMIN", dotenv.get("KEYCLOAK_ADMIN"));
        System.setProperty("KEYCLOAK_ADMIN_PASSWORD", dotenv.get("KEYCLOAK_ADMIN_PASSWORD"));
        System.setProperty("DB_ROOT_PASSWORD", dotenv.get("DB_ROOT_PASSWORD"));
        System.setProperty("KEYCLOAK_ISSUER_URI", dotenv.get("KEYCLOAK_ISSUER_URI"));
		SpringApplication.run(ApiGatewayApplication.class, args);
	}
}
