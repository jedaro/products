package com.kometsales.products.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class InventarioProductDTO {
    private String productName;
    private String basePrice;
    private Integer finalFreight;

}
