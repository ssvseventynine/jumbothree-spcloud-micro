package com.sidhant.jumbothree.customer.model;

public class Customer {
    private Long id;
    private String customerId;
    private String name;
    private String email;

    // Default Constructor
    public Customer() {}

    // Parameterized Constructor
    public Customer(Long id, String customerId, String name, String email) {
        this.id = id;
        this.customerId = customerId;
        this.name = name;
        this.email = email;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getCustomerId() { return customerId; }
    public void setCustomerId(String customerId) { this.customerId = customerId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}