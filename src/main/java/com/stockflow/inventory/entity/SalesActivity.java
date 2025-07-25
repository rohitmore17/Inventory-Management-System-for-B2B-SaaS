package com.stockflow.inventory.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class SalesActivity {
    @Id @GeneratedValue private Long id;

    @ManyToOne
    private Product product;

    private Long warehouseId;
    private Integer quantitySold;
    private LocalDateTime soldAt = LocalDateTime.now();
}
