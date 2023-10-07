package com.kometsales.products.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ProductCodeDTO {
    
    private String productName;
    private String productCode;
}
