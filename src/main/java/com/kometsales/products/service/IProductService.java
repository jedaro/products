package com.kometsales.products.service;

import java.util.List;

import com.kometsales.products.dto.InventaryDTO;
import com.kometsales.products.dto.ProductDTO;
import com.kometsales.products.exception.ProductNotFoundException;

public interface IProductService {
    
    public InventaryDTO getInventaryProducts(Integer companyId) throws ProductNotFoundException ;

    public List<ProductDTO> getCustomerProducts(Integer customerId)  throws ProductNotFoundException;

    public String getProducstCode(Integer companyId);


}
