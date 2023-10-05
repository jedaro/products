package com.kometsales.products.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kometsales.products.model.BoxType;

public interface IBoxTypeRepository extends JpaRepository<BoxType, Long>{
    
}
