package com.ecommerce.dao.impl;

import com.ecommerce.dao.OrderDao;
import com.ecommerce.entity.Order;
import com.ecommerce.repository.OrderRepository;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class OrderDaoImpl implements OrderDao {

    private final OrderRepository repo;

    public OrderDaoImpl(OrderRepository repo) { this.repo = repo; }

    @Override
    public Order save(Order order) { return repo.save(order); }

    @Override
    public Optional<Order> findById(Long id) { return repo.findById(id); }

    @Override
    public List<Order> findAll() { return repo.findAll(); }

    @Override
    public void deleteById(Long id) { repo.deleteById(id); }

    @Override
    public List<Order> findByCustomerId(Long customerId) { return repo.findByCustomerId(customerId); }
}
