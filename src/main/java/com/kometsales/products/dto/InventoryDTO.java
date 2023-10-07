package com.kometsales.products.dto;

import java.util.List;

import com.kometsales.products.util.IInventoryProduct;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class InventoryDTO {
    private Integer companyId;
    private List<IInventoryProduct> products;
}
