package com.example.customer.controller;
import com.example.customer.entity.Customer;
import com.example.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired private CustomerRepository repo;

    @GetMapping
    public List<Customer> list() { return repo.findAll(); }

    @PostMapping
    public Customer create(@RequestBody Customer c) { return repo.save(c); }

    @PutMapping("/{id}")
    public Customer update(@PathVariable Long id, @RequestBody Customer c) {
        c.setId(id);
        return repo.save(c);
    }
}
