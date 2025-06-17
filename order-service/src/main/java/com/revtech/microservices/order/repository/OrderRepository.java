package com.revtech.microservices.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revtech.microservices.order.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
