package com.finki.emt.sport.controller.web;

import com.finki.emt.sport.model.Category;
import com.finki.emt.sport.model.Manufacturer;
import com.finki.emt.sport.service.CategoryService;
import com.finki.emt.sport.service.ManufacturerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/manufacturer")
public class ManufacturerController {


    private final CategoryService categoryService;
    private final ManufacturerService manufacturerService;

    public ManufacturerController(CategoryService categoryService, ManufacturerService manufacturerService) {
        this.categoryService = categoryService;
        this.manufacturerService = manufacturerService;
    }

    @GetMapping("/add")
    public String manufacturerAdd(Model model) {
        model.addAttribute("categories", categoryService.getCategories());
        model.addAttribute("manufacturer", new Manufacturer());
        return "manufacturerAdd";
    }

    @PostMapping("/add")
    public String manufacturerSave(@ModelAttribute Category manufacturer) {
        manufacturerService.save(manufacturer.getName());
        return "success";
    }

}
