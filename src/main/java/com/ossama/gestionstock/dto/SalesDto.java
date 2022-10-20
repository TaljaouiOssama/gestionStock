package com.ossama.gestionstock.dto;


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
    private List<SalesLineDto> salesLineList;
}
