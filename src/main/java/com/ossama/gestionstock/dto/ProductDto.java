package com.ossama.gestionstock.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
public class ProductDto {
    private Integer id;
    private String code;
    private String description;
    private BigDecimal unitPriceHT;
    private BigDecimal rateTVA;
    private BigDecimal unitPriceTTC;
    private String picture;
    private CategoryDto category;
    private List<ClientOrderLineDto> clientOrderLineList;
    private List<SupplierOrderLineDto> supplierOrderLineList;
    private List<SalesLineDto> salesLineList;
    private List<StockMovementDto> stockMovementList;
}
