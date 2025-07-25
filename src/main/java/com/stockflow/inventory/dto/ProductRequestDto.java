package com.stockflow.inventory.dto;

import java.math.BigDecimal;

public class ProductRequestDto {
    private String name;
    private String sku;
    private BigDecimal price;
    private Long warehouseId;
    private int initialQuantity;

    // Default constructor
    public ProductRequestDto() {
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Long warehouseId) {
        this.warehouseId = warehouseId;
    }

    public int getInitialQuantity() {
        return initialQuantity;
    }

    public void setInitialQuantity(int initialQuantity) {
        this.initialQuantity = initialQuantity;
    }

    @Override
    public String toString() {
        return "ProductRequestDto{" +
                "name='" + name + '\'' +
                ", sku='" + sku + '\'' +
                ", price=" + price +
                ", warehouseId=" + warehouseId +
                ", initialQuantity=" + initialQuantity +
                '}';
    }
}
