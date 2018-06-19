package com.finki.emt.sport.controller.web;

import com.finki.emt.sport.model.Category;
import com.finki.emt.sport.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/add")
    public String categoryAdd(Model model) {
        model.addAttribute("categories", categoryService.getCategories());
        model.addAttribute("category", new Category());
        return "categoryAdd";
    }

    @PostMapping("/add")
    public String categorySave(@ModelAttribute Category category /*Model model*/) {
        categoryService.save(category.getName());
        return "success";
    }

}
