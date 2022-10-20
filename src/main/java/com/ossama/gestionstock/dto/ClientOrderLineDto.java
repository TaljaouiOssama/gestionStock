package com.ossama.gestionstock.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClientOrderLineDto {
    private Integer id;
    private String code;
    private ClientOrderDto clientOrder;
    private ProductDto product;
}
