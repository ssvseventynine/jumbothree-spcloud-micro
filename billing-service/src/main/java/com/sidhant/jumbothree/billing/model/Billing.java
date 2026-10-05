package com.sidhant.jumbothree.billing.model;

import java.math.BigDecimal;

public class Billing {
    private Long id;
    private String invoiceNumber;
    private BigDecimal amount;
    private String status;

    // Default Constructor
    public Billing() {}

    // Parameterized Constructor
    public Billing(Long id, String invoiceNumber, BigDecimal amount, String status) {
        this.id = id;
        this.invoiceNumber = invoiceNumber;
        this.amount = amount;
        this.status = status;
    }

    // Getters and Setters
    public Long getId() { 
        return id; 
    }
    
    public void setId(Long id) { 
        this.id = id; 
    }

    public String getInvoiceNumber() { 
        return invoiceNumber; 
    }

    public void setInvoiceNumber(String invoiceNumber) { 
        this.invoiceNumber = invoiceNumber; 
    }

    public BigDecimal getAmount() { 
        return amount; 
    }

    public void setAmount(BigDecimal amount) { 
        this.amount = amount; 
    }

    public String getStatus() { 
        return status; 
    }

    public void setStatus(String status) { 
        this.status = status; 
    }
}