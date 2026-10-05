package com.sidhant.jumbothree.order.client;

import com.sidhant.jumbothree.order.model.InventoryDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

// The name property matches exactly with the spring.application.name configured in inventory-service
@FeignClient(name = "inventory-service")
public interface InventoryClient {

    // Feign will intercept this call, query Eureka for inventory-service, and run an internal GET request
    @GetMapping("/api/v1/inventory")
    List<InventoryDTO> fetchInventoryFromDetails();
}