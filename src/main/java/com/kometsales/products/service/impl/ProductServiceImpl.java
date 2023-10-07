package com.kometsales.products.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kometsales.products.dto.InventoryDTO;
import com.kometsales.products.dto.ProductCodeDTO;
import com.kometsales.products.dto.ProductDTO;
import com.kometsales.products.exception.ProductNotFoundException;
import com.kometsales.products.model.Product;
import com.kometsales.products.repository.IInventoryRepository;
import com.kometsales.products.repository.IProductRepository;
import com.kometsales.products.service.IProductService;
import com.kometsales.products.util.IInventoryProduct;
import com.kometsales.products.util.IProduct;
import com.kometsales.products.util.IProductName;

@Component
public class ProductServiceImpl implements IProductService{

    @Autowired
    private IInventoryRepository iInventoryRepository;

    @Autowired
    private IProductRepository iProductRepository;

    @Override
    public InventoryDTO getInventoryProducts(Integer companyId) throws ProductNotFoundException {
        
        try {
            List<IInventoryProduct> result = iInventoryRepository.getInventory(companyId);
            if (!result.isEmpty()) {

                return InventoryDTO.builder().companyId(companyId).products(result).build();
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
    public List<ProductCodeDTO> getProducstCode(Integer companyId) throws ProductNotFoundException{
        try {
            List<IProductName> namesProducts = iProductRepository.getProducts(companyId);

            if (!namesProducts.isEmpty()) {
                List<ProductCodeDTO> productsCode = new ArrayList<>();
                for (IProductName p : namesProducts) {
                    String code = getCodeByName(p.getProductName());
                    productsCode.add(ProductCodeDTO.builder().productName(p.getProductName()).productCode(code).build());
                }

                return productsCode;
            } else {
                throw new ProductNotFoundException("Products code not found");
            }
            
        }  catch (Exception e) {
            throw new ProductNotFoundException("Products code not found");
        }
    }

    /**
     * Retorna el codigo del producto aplicando transformaciones a partir del nombre
     * @param productName
     * @return code
     */
    private String getCodeByName(String productName){

        String code = "";




        return "code";
    }
    
}
