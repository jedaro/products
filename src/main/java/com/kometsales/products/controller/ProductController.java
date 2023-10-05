package com.kometsales.products.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ProductController {

    @GetMapping("/")
    public String home(){
        return "Rest API Products KometSales";
    }

    // get inventary

    // get product

    // get name product
    
}
