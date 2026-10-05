package com.sidhant.jumbothree.billing.controller;

import com.sidhant.jumbothree.billing.model.Billing;
import com.sidhant.jumbothree.billing.repository.BillingRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/billing")
@CrossOrigin(origins = "*") // Prepares it for smooth connection to our future AngularJS frontend
public class BillingController {

    private final BillingRepository billingRepository;

    // Injecting the Persistence Tier
    public BillingController(BillingRepository billingRepository) {
        this.billingRepository = billingRepository;
    }

    // HTTP GET Endpoint to retrieve all invoices via the Gateway route mapping
    @GetMapping
    public List<Billing> getAllInvoices() {
        return billingRepository.findAllInvoices();
    }

    // HTTP POST Endpoint to create a new invoice entry
    @PostMapping
    public String createInvoice(@RequestBody Billing billing) {
        int status = billingRepository.saveInvoice(billing);
        return status > 0 ? "Invoice Created Successfully!" : "Invoice Creation Failed";
    }
}