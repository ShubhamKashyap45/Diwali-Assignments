package com.ecommerce.service.impl;

import com.ecommerce.dao.OrderDao;
import com.ecommerce.dao.ProductDao;
import com.ecommerce.dao.CustomerDao;
import com.ecommerce.entity.Order;
import com.ecommerce.entity.OrderItem;
import com.ecommerce.entity.Product;
import com.ecommerce.exception.ResourceNotFoundException;
import com.ecommerce.service.OrderService;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderDao orderDao;
    private final CustomerDao customerDao;
    private final ProductDao productDao;

    public OrderServiceImpl(OrderDao orderDao, CustomerDao customerDao, ProductDao productDao) {
        this.orderDao = orderDao;
        this.customerDao = customerDao;
        this.productDao = productDao;
    }

    @Override
    public Order placeOrder(Order order) {
        var cust = customerDao.findById(order.getCustomer().getId()).orElseThrow(() -> new ResourceNotFoundException("Customer not found"));
        double total = 0.0;
        for (OrderItem item : order.getOrderItems()) {
            Product p = productDao.findById(item.getProduct().getId()).orElseThrow(() -> new ResourceNotFoundException("Product not found"));
            if (p.getQuantity() < item.getQuantity()) throw new RuntimeException("Insufficient stock for product: " + p.getName());
            item.setPrice(p.getPrice());
            total += p.getPrice() * item.getQuantity();
            p.setQuantity(p.getQuantity() - item.getQuantity());
            productDao.save(p);
        }
        order.setTotalAmount(total);
        order.setOrderDate(Instant.now());
        order.setStatus(Order.Status.PENDING);
        order.setCustomer(cust);
        return orderDao.save(order);
    }

    @Override
    public Order getById(Long id) { return orderDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("Order not found")); }

    @Override
    public List<Order> getAll() { return orderDao.findAll(); }

    @Override
    public List<Order> getByCustomerId(Long customerId) { return orderDao.findByCustomerId(customerId); }

    @Override
    public Order updateStatus(Long id, String status) {
        Order o = orderDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("Order not found"));
        o.setStatus(Order.Status.valueOf(status.toUpperCase()));
        return orderDao.save(o);
    }

    @Override
    public void cancelOrder(Long id) {
        Order o = orderDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("Order not found"));
        o.setStatus(Order.Status.CANCELLED);
        for (OrderItem item : o.getOrderItems()) {
            Product p = item.getProduct();
            p.setQuantity(p.getQuantity() + item.getQuantity());
            productDao.save(p);
        }
        orderDao.save(o);
    }
}
