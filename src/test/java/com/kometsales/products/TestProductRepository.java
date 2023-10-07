package com.kometsales.products;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.kometsales.products.repository.IInventoryRepository;
import com.kometsales.products.repository.IProductRepository;
import com.kometsales.products.util.IInventoryProduct;
import com.kometsales.products.util.IProduct;
import com.kometsales.products.util.IProductName;

@DataJpaTest
public class TestProductRepository {

   @Autowired
   IProductRepository iProductRepository;

   @Autowired
   IInventoryRepository iInventoryRepository;

   @Test
   @DisplayName("Get Inventary Products Repository")
   void getInventoryProductsTest() {
      // given
      Integer companyId = 1;

      // when
      List<IInventoryProduct> inventory = iInventoryRepository.getInventory(companyId);

      // then
      assertNotNull(inventory);
      assertNotNull(inventory.get(0));

   }

   @Test
   @DisplayName("Get Customer Products Repository")
   void getCustomerProductsTest() {
      // given
      Integer customerId = 1;


      // when
      List<IProduct> products = iProductRepository.getCustomerProducts(customerId);

      // then
      assertNotNull(products);
      assertNotNull(products.get(0));

   }

   @Test
   @DisplayName("Get Products Repository")
   void getProductsTest() {
      // given
      Integer companyId = 1;


      // when
      List<IProductName> products = iProductRepository.getProducts(companyId);

      // then
      assertNotNull(products);
      assertNotNull(products.get(0));

   }

}