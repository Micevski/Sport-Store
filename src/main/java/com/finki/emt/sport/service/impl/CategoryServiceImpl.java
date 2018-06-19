package com.finki.emt.sport.service.impl;

import com.finki.emt.sport.model.Category;
import com.finki.emt.sport.repository.CategoryRepository;
import com.finki.emt.sport.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository repository;

    public CategoryServiceImpl(CategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Category> getCategories() {
        return repository.findAll();
    }

    @Override
    public Optional<Category> getCategory(Long id) {
        return repository.findById(id);
    }

    @Override
    public Category save(String name) {
        Category category = new Category(name);
        return repository.save(category);
    }
}
