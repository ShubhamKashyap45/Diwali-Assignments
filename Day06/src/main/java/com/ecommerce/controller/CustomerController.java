package com.ecommerce.controller;

import com.ecommerce.entity.Customer;
import com.ecommerce.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) { this.customerService = customerService; }

    @PostMapping
    public ResponseEntity<Customer> create(@RequestBody Customer c) { return ResponseEntity.ok(customerService.create(c)); }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getById(@PathVariable Long id) { return ResponseEntity.ok(customerService.getById(id)); }

    @GetMapping
    public ResponseEntity<List<Customer>> getAll() { return ResponseEntity.ok(customerService.getAll()); }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> update(@PathVariable Long id, @RequestBody Customer c) { return ResponseEntity.ok(customerService.update(id, c)); }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) { customerService.delete(id); return ResponseEntity.noContent().build(); }
}
