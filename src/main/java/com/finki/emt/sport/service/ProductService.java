package com.finki.emt.sport.service;

import com.finki.emt.sport.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> getProducts();
    Optional<Product> getProduct(Long id);
    Product save(Product product);
    List<Product> getAvailableProducts(Boolean available);
    List<Product> getProductsByCategory(String name);
}
