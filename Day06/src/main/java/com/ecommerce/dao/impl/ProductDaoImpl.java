package com.ecommerce.dao.impl;

import com.ecommerce.dao.ProductDao;
import com.ecommerce.entity.Product;
import com.ecommerce.repository.ProductRepository;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class ProductDaoImpl implements ProductDao {

    private final ProductRepository repo;

    public ProductDaoImpl(ProductRepository repo) { this.repo = repo; }

    @Override
    public Product save(Product product) { return repo.save(product); }

    @Override
    public Optional<Product> findById(Long id) { return repo.findById(id); }

    @Override
    public List<Product> findAll() { return repo.findAll(); }

    @Override
    public void deleteById(Long id) { repo.deleteById(id); }

    @Override
    public List<Product> findByCategory(String category) { return repo.findByCategoryContainingIgnoreCase(category); }

    @Override
    public List<Product> findByName(String name) { return repo.findByNameContainingIgnoreCase(name); }

    @Override
    public List<Product> findByPriceRange(Double low, Double high) { return repo.findByPriceBetween(low, high); }
}
