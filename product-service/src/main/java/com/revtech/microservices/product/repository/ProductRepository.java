package com.revtech.microservices.product.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.revtech.microservices.product.model.Product;

public interface ProductRepository extends MongoRepository<Product, String>{

}
