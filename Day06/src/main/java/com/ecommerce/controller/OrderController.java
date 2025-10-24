package com.ecommerce.controller;

import com.ecommerce.entity.Order;
import com.ecommerce.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) { this.orderService = orderService; }

    @PostMapping
    public ResponseEntity<Order> place(@RequestBody Order o) { return ResponseEntity.ok(orderService.placeOrder(o)); }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getById(@PathVariable Long id) { return ResponseEntity.ok(orderService.getById(id)); }

    @GetMapping
    public ResponseEntity<List<Order>> getAll() { return ResponseEntity.ok(orderService.getAll()); }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<Order>> getByCustomer(@PathVariable Long customerId) { return ResponseEntity.ok(orderService.getByCustomerId(customerId)); }

    @PutMapping("/{id}/status")
    public ResponseEntity<Order> updateStatus(@PathVariable Long id, @RequestParam String status) { return ResponseEntity.ok(orderService.updateStatus(id, status)); }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> cancel(@PathVariable Long id) { orderService.cancelOrder(id); return ResponseEntity.noContent().build(); }
}
