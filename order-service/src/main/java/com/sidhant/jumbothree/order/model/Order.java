package com.sidhant.jumbothree.order.model;

import java.math.BigDecimal;

public class Order {
    private Long id;
    private String orderId;
    private BigDecimal totalAmount;

    // Default Constructor
    public Order() {}

    // Parameterized Constructor
    public Order(Long id, String orderId, BigDecimal totalAmount) {
        this.id = id;
        this.orderId = orderId;
        this.totalAmount = totalAmount;
    }

    // Getters and Setters
    public Long getId() { 
        return id; 
    }
    
    public void setId(Long id) { 
        this.id = id; 
    }

    public String getOrderId() { 
        return orderId; 
    }

    public void setOrderId(String orderId) { 
        this.orderId = orderId; 
    }

    public BigDecimal getTotalAmount() { 
        return totalAmount; 
    }

    public void setTotalAmount(BigDecimal totalAmount) { 
        this.totalAmount = totalAmount; 
    }
}