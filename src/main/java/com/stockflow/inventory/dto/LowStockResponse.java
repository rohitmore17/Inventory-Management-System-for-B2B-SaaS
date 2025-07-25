package com.stockflow.inventory.dto;

public class LowStockResponse {

    private String productName;
    private String sku;
    private String warehouseName;
    private int quantity;

    // All-args constructor
    public LowStockResponse(String productName, String sku, String warehouseName, int quantity) {
        this.productName = productName;
        this.sku = sku;
        this.warehouseName = warehouseName;
        this.quantity = quantity;
    }

    // Getters and Setters

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "LowStockResponse{" +
                "productName='" + productName + '\'' +
                ", sku='" + sku + '\'' +
                ", warehouseName='" + warehouseName + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
