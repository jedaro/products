package com.kometsales.products.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kometsales.products.model.Product;

public interface IProductRepository extends JpaRepository<Product, Long>{
    
}
