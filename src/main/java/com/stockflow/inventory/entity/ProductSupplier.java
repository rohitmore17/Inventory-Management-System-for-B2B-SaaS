package com.stockflow.inventory.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class ProductSupplier {
    @Id @GeneratedValue private Long id;

    @ManyToOne
    private Product product;

    @ManyToOne
    private Supplier supplier;
}
