package com.ecommerce.dao;

import com.ecommerce.entity.Order;
import java.util.List;
import java.util.Optional;

public interface OrderDao {
    Order save(Order order);
    Optional<Order> findById(Long id);
    List<Order> findAll();
    void deleteById(Long id);
    List<Order> findByCustomerId(Long customerId);
}
