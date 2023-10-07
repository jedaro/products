package com.kometsales.products;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TestProductsApplication {

	@Autowired
    WebTestClient webTestClient;

    @Test
    @DisplayName("TestCase Get Inventory Products Ok")
    @Order(1)
    public void getInventoryProductsOk(){

        // given
        Integer companyId = 1;

        // when
        webTestClient.get().uri("/api/inventory?companyId="+companyId).exchange()

        // then
        .expectStatus().isOk();
    }

    @Test
    @DisplayName("TestCase Get Inventory Products Not Found")
    @Order(2)
    public void getInventoryProductsNotFound(){

        // given
        Integer companyId = 10;

        // when
        webTestClient.get().uri("/api/inventory?companyId="+companyId).exchange()
            
		    // then
            .expectStatus().isNotFound();
    }


	@Test
    @DisplayName("TestCase Get Customer Products Ok")
    @Order(3)
    public void getCustomerProductsOk(){

        // given
        Integer customerId = 1;

        // when
        webTestClient.get().uri("/api/products?customerId="+customerId).exchange()

        // then
        .expectStatus().isOk();
    }

    @Test
    @DisplayName("TestCase Get Customer Products Not Found")
    @Order(4)
    public void getCustomerProductsNotFound(){

        // given
        Integer customerId = 10;

        // when
        webTestClient.get().uri("/api/products?customerId="+customerId).exchange()
            
		    // then
            .expectStatus().isNotFound();
    }

    @Test
    @DisplayName("TestCase Get Products code Ok")
    @Order(5)
    public void getProductsCodeOk(){

        // given
        Integer companyId = 1;

        // when
        webTestClient.get().uri("/api/productsCode?companyId="+companyId).exchange()

                // then
                .expectStatus().isOk();
    }

    @Test
    @DisplayName("TestCase Get Products Code Not Found")
    @Order(6)
    public void getProductsCodeNotFound(){

        // given
        Integer companyId = 10;

        // when
        webTestClient.get().uri("/api/productsCode?companyId="+companyId).exchange()

                // then
                .expectStatus().isNotFound();
    }

}
