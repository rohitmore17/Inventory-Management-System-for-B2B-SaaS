package com.stockflow.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stockflow.inventory.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    boolean existsBySku(String sku);
}
