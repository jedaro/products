package com.kometsales.products.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ProductDTO {
    private String productName;
    private String companyName;
    private String price;
}
