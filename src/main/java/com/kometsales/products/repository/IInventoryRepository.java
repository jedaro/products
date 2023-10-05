package com.kometsales.products.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kometsales.products.model.Inventory;

public interface IInventoryRepository  extends JpaRepository<Inventory, Long>{
    
}
