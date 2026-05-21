package com.example.b2.service;

import org.springframework.stereotype.Service;

@Service
public class ProductService {

    public void addProduct(String productName) {

        System.out.println(
                "THÊM SẢN PHẨM THÀNH CÔNG: " + productName
        );
    }
}