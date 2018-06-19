package com.finki.emt.sport.controller.rest;

import com.finki.emt.sport.model.Category;
import com.finki.emt.sport.service.impl.CategoryServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/category")
public class CategoryResources {

    private final CategoryServiceImpl service;

    public CategoryResources(CategoryServiceImpl service) {
        this.service = service;
    }
    @GetMapping
    public List<Category> getCategories(){
        return service.getCategories();
    }

    @PostMapping
    public Category create(@RequestBody String name){
       return service.save(name);
    }

}
