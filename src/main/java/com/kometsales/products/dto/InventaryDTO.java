package com.kometsales.products.dto;

import java.util.List;

import com.kometsales.products.util.IInventaryProduct;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class InventaryDTO {
    private Integer companyId;
    private List<IInventaryProduct> products;
}
