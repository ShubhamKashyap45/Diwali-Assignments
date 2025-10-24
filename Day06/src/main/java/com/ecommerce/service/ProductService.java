package com.ecommerce.service;

import com.ecommerce.entity.Product;
import java.util.List;

public interface ProductService {
    Product create(Product product);
    Product update(Long id, Product product);
    Product getById(Long id);
    List<Product> getAll();
    void delete(Long id);
    List<Product> searchByCategory(String category);
    List<Product> searchByName(String name);
    List<Product> findByPriceRange(Double low, Double high);
}
