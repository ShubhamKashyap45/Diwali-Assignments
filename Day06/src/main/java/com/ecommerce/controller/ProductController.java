package com.ecommerce.controller;

import com.ecommerce.entity.Product;
import com.ecommerce.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) { this.productService = productService; }

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody Product p) { return ResponseEntity.ok(productService.create(p)); }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable Long id) { return ResponseEntity.ok(productService.getById(id)); }

    @GetMapping
    public ResponseEntity<List<Product>> getAll() { return ResponseEntity.ok(productService.getAll()); }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable Long id, @RequestBody Product p) { return ResponseEntity.ok(productService.update(id, p)); }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) { productService.delete(id); return ResponseEntity.noContent().build(); }

    @GetMapping("/search/category")
    public ResponseEntity<List<Product>> byCategory(@RequestParam String category) { return ResponseEntity.ok(productService.searchByCategory(category)); }

    @GetMapping("/search/name")
    public ResponseEntity<List<Product>> byName(@RequestParam String name) { return ResponseEntity.ok(productService.searchByName(name)); }

    @GetMapping("/range")
    public ResponseEntity<List<Product>> byPriceRange(@RequestParam Double low, @RequestParam Double high) { return ResponseEntity.ok(productService.findByPriceRange(low, high)); }
}
