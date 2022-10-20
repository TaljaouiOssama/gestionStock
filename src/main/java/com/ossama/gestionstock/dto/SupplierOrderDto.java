package com.ossama.gestionstock.dto;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;
@Data
@Builder
public class SupplierOrderDto {
    private Integer id;
    private String code;
    private Instant orderDate;
    private List<SupplierOrderLineDto> supplierOrderLineList;
    private SupplierDto supplier;
}
