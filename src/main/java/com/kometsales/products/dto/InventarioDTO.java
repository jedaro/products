package com.kometsales.products.dto;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class InventarioDTO {
    private Integer companyId;
    private List<InventarioProductDTO> products;
}
