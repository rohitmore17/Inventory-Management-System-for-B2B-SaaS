package com.stockflow.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stockflow.inventory.entity.Warehouse;

public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {
}