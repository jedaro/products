package com.kometsales.products.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kometsales.products.model.Customer;

public interface ICustomerRepository extends JpaRepository<Customer, Long> {
    
}
