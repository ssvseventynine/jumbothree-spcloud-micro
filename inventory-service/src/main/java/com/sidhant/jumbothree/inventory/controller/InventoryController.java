package com.sidhant.jumbothree.inventory.controller;

import com.sidhant.jumbothree.inventory.model.Inventory;
import com.sidhant.jumbothree.inventory.repository.InventoryRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/inventory")
@CrossOrigin(origins = "*") // Allows our future AngularJS frontend to make calls smoothly
public class InventoryController {

    private final InventoryRepository inventoryRepository;

    // Injection of our Persistence Tier
    public InventoryController(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    // HTTP GET Endpoint to retrieve all records
    @GetMapping
    public List<Inventory> getAllInventory() {
        return inventoryRepository.findAllItems();
    }

    // HTTP POST Endpoint to insert a new record
    @PostMapping
    public String addInventoryItem(@RequestBody Inventory inventory) {
        int status = inventoryRepository.saveItem(inventory);
        return status > 0 ? "Inventory Item Saved Successfully!" : "Insertion Failed";
    }
}