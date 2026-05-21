package com.example.b2.controller;

import com.example.b2.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/add")
    public String addProduct() {

        productService.addProduct("Laptop");

        return "them thanh cong";
    }
}