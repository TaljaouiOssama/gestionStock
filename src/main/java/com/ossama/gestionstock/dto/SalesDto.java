package com.ossama.gestionstock.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ossama.gestionstock.model.Sales;
import lombok.Builder;
import lombok.Data;


import java.time.Instant;
import java.util.List;

@Data
@Builder
public class SalesDto {
    private Integer id;
    private String code;
    private Instant salesDate;
    @JsonIgnore
    private List<SalesLineDto> salesLineList;
    public static SalesDto fromEntity(Sales sales){
        if(sales==null)
            return null;
        return SalesDto.builder()
                .id(sales.getId())
                .code(sales.getCode())
                .salesDate(sales.getSalesDate())
                .build();
    }
    public static Sales toEntity(SalesDto salesDto){
        if(salesDto==null)
            return null;
        Sales sales=new Sales();
        sales.setId(salesDto.getId());
        sales.setCode(salesDto.getCode());
        sales.setSalesDate(salesDto.getSalesDate());
        return sales;
    }
}
