package com.kometsales.products;

import com.kometsales.products.dto.ProductCodeDTO;
import com.kometsales.products.util.IProductName;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.projection.ProjectionFactory;
import org.springframework.data.projection.SpelAwareProxyProjectionFactory;

import com.kometsales.products.dto.InventoryDTO;
import com.kometsales.products.dto.ProductDTO;
import com.kometsales.products.exception.ProductNotFoundException;
import com.kometsales.products.repository.IInventoryRepository;
import com.kometsales.products.repository.IProductRepository;
import com.kometsales.products.service.impl.ProductServiceImpl;
import com.kometsales.products.util.IInventoryProduct;
import com.kometsales.products.util.IProduct;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class TestProductService {

    @InjectMocks
    private ProductServiceImpl productServiceImpl;

    @Mock
    private IInventoryRepository iInventoryRepository;

    @Mock
    private IProductRepository iProductRepository;


    @Test
    @DisplayName("Get Inventory Product Service Ok")
     void getInventoryProductsOk() throws ProductNotFoundException{
        //given   
       List<IInventoryProduct>  inventory = new ArrayList<>();  
       ProjectionFactory factory = new SpelAwareProxyProjectionFactory();
       IInventoryProduct projection = factory.createProjection(IInventoryProduct.class);
       projection.setProductName("product 1");
       projection.setBasePrice("2.60");
       projection.setFinalFreight(3.43);
       inventory.add(0, projection);
        
    
        //when
        given(iInventoryRepository.getInventory(1)).willReturn(inventory);
        InventoryDTO inventoryResult = productServiceImpl.getInventoryProducts(1);
       
        //then
        assertNotNull(inventoryResult);
        assertEquals(1, inventoryResult.getCompanyId());

    }

    @Test
    @DisplayName("Get Inventory Product Service No Found")
     void getInventoryProductsNotFound() throws ProductNotFoundException{
        //given   
       List<IInventoryProduct>  inventory = new ArrayList<>();  

        //when
        given(iInventoryRepository.getInventory(1)).willReturn(inventory);
        
        // then
        assertThrows(ProductNotFoundException.class, () -> productServiceImpl.getInventoryProducts(1));

    }

    @Test
    @DisplayName("Get Customer Product Service Ok")
     void getCustomerProductsOk() throws ProductNotFoundException{

        //given
       List<IProduct>  products = new ArrayList<>();  
       ProjectionFactory factory = new SpelAwareProxyProjectionFactory();
       IProduct projection = factory.createProjection(IProduct.class);
       projection.setProductName("product 1");
       projection.setCompanyName("company 1");
       projection.setPrice("3.43");
       products.add(0, projection);

       //when
       given(iProductRepository.getCustomerProducts(1)).willReturn(products);
       List<ProductDTO> customerProducts = productServiceImpl.getCustomerProducts(1);

       //then
       assertNotNull(customerProducts);
       assertEquals(1, customerProducts.size());

    }

    @Test
    @DisplayName("Get Customer Product Service Not Found")
     void getCustomerProductsNotFound() throws ProductNotFoundException{

        //given
       List<IProduct>  products = new ArrayList<>();  
  
       //when
       given(iProductRepository.getCustomerProducts(1)).willReturn(products);

       //then
        assertThrows(ProductNotFoundException.class, () -> productServiceImpl.getCustomerProducts(1));

    }

    @Test
    @DisplayName("Get Product Code Service Ok")
     void getProducstCode() throws ProductNotFoundException {
        //given
        Integer companyId = 1;
        List<IProductName>  nameProducts = new ArrayList<>();
        ProjectionFactory factory = new SpelAwareProxyProjectionFactory();
        IProductName projection = factory.createProjection(IProductName.class);
        projection.setProductName("Product 1");
        nameProducts.add(0, projection);

        //when
        given(iProductRepository.getProducts(1)).willReturn(nameProducts);
        List<ProductCodeDTO> products = productServiceImpl.getProducstCode(companyId);

        //then
        assertNotNull(products);
        assertEquals(1, products.size());

    }

    @Test
    @DisplayName("Get Product Code Service Exception")
    void getProducstCodeNotFound() throws ProductNotFoundException {
        //given
        Integer companyId = 1;
        List<IProductName>  nameProducts = new ArrayList<>();

        //when
        given(iProductRepository.getProducts(1)).willReturn(nameProducts);

        //then
        assertThrows(ProductNotFoundException.class, () ->  productServiceImpl.getProducstCode(companyId));

    }

    
}
