package com.sidhant.jumbothree.customer.controller;

import com.sidhant.jumbothree.customer.model.Customer;
import com.sidhant.jumbothree.customer.repository.CustomerRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
@CrossOrigin(origins = "*")
public class CustomerController {

    private final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerRepository.findAllCustomers();
    }

    @PostMapping
    public String createCustomer(@RequestBody Customer customer) {
        int status = customerRepository.saveCustomer(customer);
        return status > 0 ? "Customer Registered Successfully!" : "Registration Failed";
    }
}