package com.stockflow.inventory.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stockflow.inventory.dto.LowStockResponse;
import com.stockflow.inventory.entity.Inventory;
import com.stockflow.inventory.repository.InventoryRepository;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    private final InventoryRepository inventoryRepo;

    public InventoryController(InventoryRepository inventoryRepo) {
        this.inventoryRepo = inventoryRepo;
    }

    @GetMapping("/low-stock")
    public ResponseEntity<?> getLowStock(@RequestParam(defaultValue = "10") int threshold) {
        List<Inventory> lowStock = inventoryRepo.findLowStock(threshold);

        List<LowStockResponse> response = lowStock.stream()
            .map(i -> new LowStockResponse(
                i.getProduct().getName(),
                i.getProduct().getSku(),
                i.getWarehouse().getName(),
                i.getQuantity()
            ))
            .collect(Collectors.toList());

        return ResponseEntity.ok(response);
    }
}
