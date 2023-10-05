package com.kometsales.products.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kometsales.products.model.Company;

public interface ICompanyRepository extends JpaRepository<Company, Long>{
    
}
