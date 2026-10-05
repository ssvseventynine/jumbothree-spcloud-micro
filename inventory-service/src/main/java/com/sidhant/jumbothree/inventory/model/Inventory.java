package com.sidhant.jumbothree.inventory.model;

public class Inventory {
    private Long id;
    private String itemCode;
    private Integer stockLevel;

    // Default Constructor
    public Inventory() {}

    // Parameterized Constructor
    public Inventory(Long id, String itemCode, Integer stockLevel) {
        this.id = id;
        this.itemCode = itemCode;
        this.stockLevel = stockLevel;
    }

    // Getters and Setters
    public Long getId() { 
        return id; 
    }
    
    public void setId(Long id) { 
        this.id = id; 
    }

    public String getItemCode() { 
        return itemCode; 
    }

    public void setItemCode(String itemCode) { 
        this.itemCode = itemCode; 
    }

    public Integer getStockLevel() { 
        return stockLevel; 
    }

    public void setStockLevel(Integer stockLevel) { 
        this.stockLevel = stockLevel; 
    }
}