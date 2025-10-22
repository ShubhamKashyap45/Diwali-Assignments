package com.example.productapi.controller;
import com.example.productapi.entity.Product;
import com.example.productapi.repository.ProductRepository;
import com.example.productapi.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired private ProductRepository productRepo;
    @Autowired private CategoryRepository categoryRepo;

    // a. Display all products with category information
    @GetMapping
    public List<Product> all() { return productRepo.findAll(); }

    // b. Insert new product
    @PostMapping
    public Product create(@RequestBody Product p) { return productRepo.save(p); }

    // c. Display products having price in the given range
    @GetMapping("/range")
    public List<Product> byRange(@RequestParam Double low, @RequestParam Double high) {
        return productRepo.findByPriceBetween(low, high);
    }

    // d. Update product of given product_id with new price
    @PutMapping("/{id}/price")
    public Product updatePrice(@PathVariable Long id, @RequestParam Double price) {
        Optional<Product> op = productRepo.findById(id);
        if (op.isPresent()) {
            Product p = op.get();
            p.setPrice(price);
            return productRepo.save(p);
        }
        throw new RuntimeException("Product not found");
    }
}
