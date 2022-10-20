package com.ossama.gestionstock.dto;


import com.ossama.gestionstock.model.TypeMvtStk;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@Builder
public class StockMovementDto {
    private Integer id;
    private Instant mvtDate;
    private BigDecimal quantity;
    private TypeMvtStk type;
    private ProductDto product;

}
