package com.stockflow.inventory.controller;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stockflow.inventory.dto.ProductRequestDto;
import com.stockflow.inventory.entity.Inventory;
import com.stockflow.inventory.entity.Product;
import com.stockflow.inventory.entity.Warehouse;
import com.stockflow.inventory.repository.InventoryRepository;
import com.stockflow.inventory.repository.ProductRepository;
import com.stockflow.inventory.repository.WarehouseRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductRepository productRepo = null;
    private final WarehouseRepository warehouseRepo = null;
    private final InventoryRepository inventoryRepo = null;

    @PostMapping
    public ResponseEntity<?> createProduct(@RequestBody ProductRequestDto dto) {
        if (productRepo.existsBySku(dto.getSku())) {
            return ResponseEntity.badRequest().body("SKU must be unique");
        }

        Warehouse warehouse = warehouseRepo.findById(dto.getWarehouseId())
            .orElseThrow(() -> new RuntimeException("Warehouse not found"));

        Product product = new Product();
        product.setName(dto.getName());
        product.setSku(dto.getSku());
        product.setPrice(dto.getPrice());
        product.getWarehouses().add(warehouse);
        product = productRepo.save(product);

        Inventory inventory = new Inventory();
        inventory.setProduct(product);
        inventory.setWarehouse(warehouse);
        inventory.setQuantity(dto.getInitialQuantity());
        inventory.setLastUpdated(LocalDateTime.now());
        inventoryRepo.save(inventory);

        return ResponseEntity.ok(Map.of("message", "Product created", "product_id", product.getId()));
    }
}
