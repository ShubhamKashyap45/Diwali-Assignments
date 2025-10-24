package com.ecommerce.service;

import com.ecommerce.entity.Order;
import java.util.List;

public interface OrderService {
    Order placeOrder(Order order);
    Order getById(Long id);
    List<Order> getAll();
    List<Order> getByCustomerId(Long customerId);
    Order updateStatus(Long id, String status);
    void cancelOrder(Long id);
}
