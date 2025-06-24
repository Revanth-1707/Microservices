package com.revtech.api_gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	
	
	private final String[] freeResourceUrls = {"/swagger-ui.html","/swagger-ui/**","/v3/api-docs/**","/swagger-resources/**","/api-docs/**","/aggregate/**"};
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
		return httpSecurity.authorizeHttpRequests(authorize -> authorize
				.requestMatchers(freeResourceUrls)
				.permitAll()
				.anyRequest()  // for any request user to be authenticated. No public endpoints
				.authenticated())
				.oauth2ResourceServer(oauth2 -> oauth2.jwt(Customizer.withDefaults()))
				.build();
	}

}

//SecurityFilterChain: it is interface defines security rules for HTTP requests.
//HttpSecurity: It is Spring Security's main class for configuring HTTP security.
