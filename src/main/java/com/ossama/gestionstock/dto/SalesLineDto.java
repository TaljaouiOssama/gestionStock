package com.ossama.gestionstock.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class SalesLineDto {
    private Integer id;
    private String code;
    private BigDecimal quantity;
    private SalesDto sales;
    private ProductDto product;
}
