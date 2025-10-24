package com.ecommerce.dao.impl;

import com.ecommerce.dao.CustomerDao;
import com.ecommerce.entity.Customer;
import com.ecommerce.repository.CustomerRepository;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class CustomerDaoImpl implements CustomerDao {

    private final CustomerRepository repo;

    public CustomerDaoImpl(CustomerRepository repo) {
        this.repo = repo;
    }

    @Override
    public Customer save(Customer customer) { return repo.save(customer); }

    @Override
    public Optional<Customer> findById(Long id) { return repo.findById(id); }

    @Override
    public List<Customer> findAll() { return repo.findAll(); }

    @Override
    public void deleteById(Long id) { repo.deleteById(id); }

    @Override
    public Optional<Customer> findByEmail(String email) { return repo.findByEmail(email); }
}
