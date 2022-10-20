package com.ossama.gestionstock.dto;

import com.ossama.gestionstock.model.SalesLine;
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
    public static SalesLineDto fromEntity(SalesLine salesLine){
        if(salesLine==null)
            return null;
        return SalesLineDto.builder()
                .id(salesLine.getId())
                .code(salesLine.getCode())
                .quantity(salesLine.getQuantity())
                .sales(SalesDto.fromEntity(salesLine.getSales()))
                .product(ProductDto.fromEntity(salesLine.getProduct()))
                .build();
    }
    public static SalesLine toEntity(SalesLineDto salesLineDto){
        if(salesLineDto==null)
            return null;
        SalesLine salesLine= new SalesLine();
        salesLine.setId(salesLineDto.getId());
        salesLine.setCode(salesLineDto.getCode());
        salesLine.setQuantity(salesLineDto.getQuantity());
        salesLine.setSales(SalesDto.toEntity(salesLineDto.getSales()));
        salesLine.setProduct(ProductDto.toEntity(salesLineDto.getProduct()));
        return salesLine;
    }
}
