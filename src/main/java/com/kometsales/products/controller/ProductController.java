package com.kometsales.products.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.kometsales.products.dto.InventaryDTO;
import com.kometsales.products.dto.ProductDTO;
import com.kometsales.products.exception.ProductNotFoundException;
import com.kometsales.products.service.IProductService;

@RestController
@RequestMapping("/api")
public class ProductController<InventaryDTO> {

    @Autowired
    private IProductService iProductService;

    @GetMapping("/inventary")
    public ResponseEntity<InventaryDTO> getInventaryProducts(@RequestParam(value = "companyId") Integer companyId) {

        try {

            return new ResponseEntity<InventaryDTO>((InventaryDTO) iProductService.getInventaryProducts(companyId), HttpStatus.OK);

        } catch (ProductNotFoundException e) {

            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Inventary not fund");
        }

    }

    @GetMapping("/products")
    public ResponseEntity<List<ProductDTO>> getCustomerProducts(@RequestParam(value = "customerId") Integer customerId) {

        try {

            return new ResponseEntity<List<ProductDTO>>(iProductService.getCustomerProducts(customerId), HttpStatus.OK);

        } catch (ProductNotFoundException e) {

            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Products not fund");
        }

    }

    
}
