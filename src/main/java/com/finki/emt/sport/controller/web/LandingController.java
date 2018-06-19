package com.finki.emt.sport.controller.web;

import com.finki.emt.sport.model.Product;
import com.finki.emt.sport.service.CategoryService;
import com.finki.emt.sport.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
@Controller
@RequestMapping
public class LandingController {

    private final CategoryService categoryService;
    private final ProductService productService;

    public LandingController(CategoryService categoryService, ProductService productService) {
        this.categoryService = categoryService;
        this.productService = productService;
    }

    @GetMapping
    public String index(Model model){
        model.addAttribute("categories", categoryService.getCategories());
        model.addAttribute("products", productService.getAvailableProducts(true));
        return "index";
    }
    @GetMapping("/{categoryName}")
    public String categoryPage(Model model, @PathVariable String categoryName){
        model.addAttribute("categories", categoryService.getCategories());
        model.addAttribute("products", productService.getProductsByCategory(categoryName));
        return "index";
    }
    @GetMapping("/products/{productId}")
    public String productPage(Model model, @PathVariable Long productId){
        model.addAttribute("categories", categoryService.getCategories());
        Optional<Product> product = productService.getProduct(productId);
        model.addAttribute("product", product.orElse(null));
        return "product";
    }
}
