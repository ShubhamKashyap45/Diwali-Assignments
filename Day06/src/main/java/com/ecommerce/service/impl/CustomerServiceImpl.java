package com.ecommerce.service.impl;

import com.ecommerce.dao.CustomerDao;
import com.ecommerce.entity.Customer;
import com.ecommerce.exception.ResourceNotFoundException;
import com.ecommerce.service.CustomerService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerDao customerDao;

    public CustomerServiceImpl(CustomerDao customerDao) { this.customerDao = customerDao; }

    @Override
    public Customer create(Customer customer) { return customerDao.save(customer); }

    @Override
    public Customer update(Long id, Customer customer) {
        Customer existing = customerDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer not found"));
        existing.setFirstName(customer.getFirstName());
        existing.setLastName(customer.getLastName());
        existing.setEmail(customer.getEmail());
        existing.setAddress(customer.getAddress());
        existing.setPhoneNumber(customer.getPhoneNumber());
        return customerDao.save(existing);
    }

    @Override
    public Customer getById(Long id) { return customerDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer not found")); }

    @Override
    public List<Customer> getAll() { return customerDao.findAll(); }

    @Override
    public void delete(Long id) { customerDao.deleteById(id); }
}
