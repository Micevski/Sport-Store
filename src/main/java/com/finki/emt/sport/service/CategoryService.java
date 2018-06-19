package com.finki.emt.sport.service;

import com.finki.emt.sport.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    List<Category> getCategories();
    Optional<Category> getCategory(Long id);
    Category save(String name);


}
