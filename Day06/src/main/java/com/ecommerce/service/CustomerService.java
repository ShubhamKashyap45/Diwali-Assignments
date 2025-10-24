package com.ecommerce.service;

import com.ecommerce.entity.Customer;
import java.util.List;

public interface CustomerService {
    Customer create(Customer customer);
    Customer update(Long id, Customer customer);
    Customer getById(Long id);
    List<Customer> getAll();
    void delete(Long id);
}
