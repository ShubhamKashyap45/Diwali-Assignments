package com.ecommerce.dao;

import com.ecommerce.entity.Product;
import java.util.List;
import java.util.Optional;

public interface ProductDao {
    Product save(Product product);
    Optional<Product> findById(Long id);
    List<Product> findAll();
    void deleteById(Long id);
    List<Product> findByCategory(String category);
    List<Product> findByName(String name);
    List<Product> findByPriceRange(Double low, Double high);
}
