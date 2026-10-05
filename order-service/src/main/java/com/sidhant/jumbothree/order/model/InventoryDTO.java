package com.sidhant.jumbothree.order.model;

public class InventoryDTO {
    private Long id;
    private String itemCode;
    private Integer stockLevel;

    // Default Constructor
    public InventoryDTO() {}

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getItemCode() { return itemCode; }
    public void setItemCode(String itemCode) { this.itemCode = itemCode; }
    public Integer getStockLevel() { return stockLevel; }
    public void setStockLevel(Integer stockLevel) { this.stockLevel = stockLevel; }
}