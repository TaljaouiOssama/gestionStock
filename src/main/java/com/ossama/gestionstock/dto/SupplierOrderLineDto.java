package com.ossama.gestionstock.dto;


import lombok.Builder;
import lombok.Data;



@Data
@Builder
public class SupplierOrderLineDto {
    private Integer id;
    private String code;
    private SupplierOrderDto supplierOrder;
    private ProductDto product;
}
