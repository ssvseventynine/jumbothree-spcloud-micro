package com.sidhant.jumbothree.order.controller;

import com.sidhant.jumbothree.order.client.InventoryClient;
import com.sidhant.jumbothree.order.model.InventoryDTO;
import com.sidhant.jumbothree.order.model.Order;
import com.sidhant.jumbothree.order.repository.OrderRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
@CrossOrigin(origins = "*")
public class OrderController {

    private final OrderRepository orderRepository;
    private final InventoryClient inventoryClient; // Injecting our Feign bridge

    public OrderController(OrderRepository orderRepository, InventoryClient inventoryClient) {
        this.orderRepository = orderRepository;
        this.inventoryClient = inventoryClient;
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return orderRepository.findAllOrders();
    }

    // New Test Endpoint: Fetches data directly from another service behind the scenes!
    @GetMapping("/check-stock")
    public List<InventoryDTO> checkSystemStockViaBackchannel() {
        System.out.println("Order Service is executing an internal Feign backchannel call...");
        return inventoryClient.fetchInventoryFromDetails();
    }

    @PostMapping
    public String createOrder(@RequestBody Order order) {
        int status = orderRepository.saveOrder(order);
        return status > 0 ? "Order Created Successfully!" : "Order Creation Failed";
    }
}