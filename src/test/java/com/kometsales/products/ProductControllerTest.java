package com.kometsales.products;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.kometsales.products.dto.InventoryDTO;
import com.kometsales.products.dto.ProductDTO;
import com.kometsales.products.exception.ProductNotFoundException;
import com.kometsales.products.service.IProductService;
import com.kometsales.products.util.IInventoryProduct;
import com.kometsales.products.util.IProduct;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import java.util.ArrayList;
import java.util.List;

@WebMvcTest
public class ProductControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    IProductService iProductService;

    @Test
    @DisplayName("Get Inventory Product Ok")
    void getInventoryProductsOk() throws Exception {
        // given
        Integer companyId = 1;

        // when

        given(iProductService.getInventoryProducts(companyId))
                .willReturn(InventoryDTO.builder().companyId(1).products(null).build());

        mockMvc.perform(get("/api/inventory")
                .param("companyId", String.valueOf(companyId)))

                // then
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.jsonPath("$.companyId").isNotEmpty());

    }

    @Test
    @DisplayName("Get Inventory Product Not Found")
    void getInventoryProductsNotFoud() throws Exception {
        // given
        Integer companyId = 1;

        // when

        given(iProductService.getInventoryProducts(companyId))
                .willThrow(new ProductNotFoundException("Inventory not found"));

        mockMvc.perform(get("/api/inventory")
                .param("companyId", String.valueOf(companyId)))

                // then
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isNotFound());

    }

    @Test
    @DisplayName("Get Customer Product Ok")
    void getCustomerProductsOk() throws Exception {
        // given
        Integer customerId = 1;
        List<ProductDTO> products = new ArrayList<>();
        products.add(ProductDTO.builder().productName("product1").companyName("company1").price("32.0").build());

        // when

        given(iProductService.getCustomerProducts(customerId))
                .willReturn(products);

        mockMvc.perform(get("/api/products")
                .param("customerId", String.valueOf(customerId)))

                // then
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE));

    }

    @Test
    @DisplayName("Get Customer Product Not Found")
    void getCustomerProductsNotFound() throws Exception {
        // given
        Integer customerId = 1;

        // when
        given(iProductService.getCustomerProducts(customerId))
                .willThrow(new ProductNotFoundException("Products not found"));

        mockMvc.perform(get("/api/products")
                .param("customerId", String.valueOf(customerId)))

                // then
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isNotFound());

    }

}
