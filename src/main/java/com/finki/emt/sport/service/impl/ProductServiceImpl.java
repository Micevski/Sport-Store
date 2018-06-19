package com.finki.emt.sport.service.impl;

import com.finki.emt.sport.model.Product;
import com.finki.emt.sport.repository.ProductRepository;
import com.finki.emt.sport.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;

    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Product> getProducts() {
        return repository.findAll();
    }

    @Override
    public Optional<Product> getProduct(Long id) {
        return repository.findById(id);
    }

    @Override
    public Product save(Product product) {
        return repository.save(product);
    }

    @Override
    public List<Product> getAvailableProducts(Boolean available) {
        return repository.findByAvailable(true);
    }

    @Override
    public List<Product> getProductsByCategory(String name) {
        return repository.findByCategory_Name(name);
    }

}
