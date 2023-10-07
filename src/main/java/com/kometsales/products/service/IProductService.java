package com.kometsales.products.service;

import java.util.List;

import com.kometsales.products.dto.InventoryDTO;
import com.kometsales.products.dto.ProductCodeDTO;
import com.kometsales.products.dto.ProductDTO;
import com.kometsales.products.exception.ProductNotFoundException;

public interface IProductService {
    
    public InventoryDTO getInventoryProducts(Integer companyId) throws ProductNotFoundException ;

    public List<ProductDTO> getCustomerProducts(Integer customerId)  throws ProductNotFoundException;

    public List<ProductCodeDTO> getProducstCode(Integer companyId) throws ProductNotFoundException;


}
