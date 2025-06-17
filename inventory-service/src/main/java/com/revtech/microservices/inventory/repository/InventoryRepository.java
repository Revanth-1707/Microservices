package com.revtech.microservices.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revtech.microservices.inventory.model.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Long>{

	Boolean existsBySkuCodeAndQuantityIsGreaterThanEqual(String skuCode, Integer quantity);

}
