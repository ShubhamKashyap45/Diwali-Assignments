package com.ecommerce.service.impl;

import com.ecommerce.dao.ProductDao;
import com.ecommerce.entity.Product;
import com.ecommerce.exception.ResourceNotFoundException;
import com.ecommerce.service.ProductService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductDao productDao;

    public ProductServiceImpl(ProductDao productDao) { this.productDao = productDao; }

    @Override
    public Product create(Product product) { return productDao.save(product); }

    @Override
    public Product update(Long id, Product product) {
        Product existing = productDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found"));
        existing.setName(product.getName());
        existing.setDescription(product.getDescription());
        existing.setPrice(product.getPrice());
        existing.setQuantity(product.getQuantity());
        existing.setCategory(product.getCategory());
        return productDao.save(existing);
    }

    @Override
    public Product getById(Long id) { return productDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found")); }

    @Override
    public List<Product> getAll() { return productDao.findAll(); }

    @Override
    public void delete(Long id) { productDao.deleteById(id); }

    @Override
    public List<Product> searchByCategory(String category) { return productDao.findByCategory(category); }

    @Override
    public List<Product> searchByName(String name) { return productDao.findByName(name); }

    @Override
    public List<Product> findByPriceRange(Double low, Double high) { return productDao.findByPriceRange(low, high); }
}
