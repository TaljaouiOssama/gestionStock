package com.ossama.gestionstock.dto;


import com.ossama.gestionstock.model.StockMovement;
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

    public static StockMovementDto fromEntity(StockMovement stockMovement){
        if(stockMovement==null)
            return null;
        return StockMovementDto.builder()
                .id(stockMovement.getId())
                .mvtDate(stockMovement.getMvtDate())
                .quantity(stockMovement.getQuantity())
                .type(stockMovement.getType())
                .product(ProductDto.fromEntity(stockMovement.getProduct()))
                .build();
    }
    public static StockMovement toEntity(StockMovementDto stockMovementDto){
        if(stockMovementDto==null)
            return null;
        StockMovement stockMovement=new StockMovement();
        stockMovement.setId(stockMovementDto.getId());
        stockMovement.setMvtDate(stockMovementDto.getMvtDate());
        stockMovement.setQuantity(stockMovementDto.getQuantity());
        stockMovement.setType(stockMovementDto.getType());
        stockMovement.setProduct(ProductDto.toEntity(stockMovementDto.getProduct()));
        return stockMovement;
    }

}
