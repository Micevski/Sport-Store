package com.finki.emt.sport.controller.web;

import com.finki.emt.sport.model.Category;
import com.finki.emt.sport.model.Manufacturer;
import com.finki.emt.sport.model.Product;
import com.finki.emt.sport.service.CategoryService;
import com.finki.emt.sport.service.ManufacturerService;
import com.finki.emt.sport.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequestMapping("/product")
public class ProductController {


    private final CategoryService categoryService;
    private final ProductService productService;
    private final ManufacturerService manufacturerService;

    public ProductController(CategoryService categoryService, ProductService productService, ManufacturerService manufacturerService) {
        this.categoryService = categoryService;
        this.productService = productService;
        this.manufacturerService = manufacturerService;
    }

    @GetMapping("/add")
    public String productAdd(Model model) {
        model.addAttribute("categories", categoryService.getCategories());
        model.addAttribute("manufacturers", manufacturerService.getManufacturers());
        model.addAttribute("product", new Product());
        return "productAdd";
    }

    @PostMapping("/add")
    public String productSave(@ModelAttribute Product product, @RequestParam("file") MultipartFile file, Model model) throws IOException {
        productService.save(product);
        product.setPhotoData(file.getBytes());
        productService.save(product);
        return "success";
    }

}
