package com.ecommerce.dao;

import com.ecommerce.entity.Customer;
import java.util.List;
import java.util.Optional;

public interface CustomerDao {
    Customer save(Customer customer);
    Optional<Customer> findById(Long id);
    List<Customer> findAll();
    void deleteById(Long id);
    Optional<Customer> findByEmail(String email);
}
