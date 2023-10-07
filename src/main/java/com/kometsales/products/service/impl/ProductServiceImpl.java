package com.kometsales.products.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kometsales.products.dto.InventaryDTO;
import com.kometsales.products.dto.ProductDTO;
import com.kometsales.products.exception.ProductNotFoundException;
import com.kometsales.products.repository.IInventoryRepository;
import com.kometsales.products.repository.IProductRepository;
import com.kometsales.products.service.IProductService;
import com.kometsales.products.util.IInventaryProduct;
import com.kometsales.products.util.IProduct;

@Component
public class ProductServiceImpl implements IProductService{

    @Autowired
    private IInventoryRepository iInventoryRepository;

    @Autowired
    private IProductRepository iProductRepository;

    @Override
    public InventaryDTO getInventaryProducts(Integer companyId) throws ProductNotFoundException {
        
        try {
            List<IInventaryProduct> result = iInventoryRepository.getInventaryProducts(companyId);
            if (!result.isEmpty()) {

                return InventaryDTO.builder().companyId(companyId).products(result).build();
            } else {
                throw new ProductNotFoundException("Inventary not found");
            }
        } catch (Exception e) {
            throw new ProductNotFoundException("Inventary not found");
        }
    }

    @Override
    public List<ProductDTO> getCustomerProducts(Integer customerId) throws ProductNotFoundException {
        
        try {
            List<IProduct> result = iProductRepository.getCustomerProducts(customerId);
            if (!result.isEmpty()) {
                List<ProductDTO> products = new ArrayList<>();
                for (IProduct p : result) {
                    products.add(ProductDTO.builder()
                            .productName(p.getProductName())
                            .companyName(p.getCompanyName())
                            .price(p.getPrice())
                            .build());
                }

                return products;

            } else {
                throw new ProductNotFoundException("Products not found");
            }
        } catch (Exception e) {
            throw new ProductNotFoundException("Products not found");
        }
    }

    @Override
    public String getProducstCode(Integer companyId) {
        throw new UnsupportedOperationException("Unimplemented method 'getProducstCode'");
    }
    
}
