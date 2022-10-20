package com.ossama.gestionstock.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ossama.gestionstock.model.Product;
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
    @JsonIgnore
    private List<ClientOrderLineDto> clientOrderLineList;
    @JsonIgnore
    private List<SupplierOrderLineDto> supplierOrderLineList;
    @JsonIgnore
    private List<SalesLineDto> salesLineList;
    @JsonIgnore
    private List<StockMovementDto> stockMovementList;
    public static ProductDto fromEntity(Product product){
        if(product==null)
        return null;
        return ProductDto.builder()
                .id(product.getId())
                .code(product.getCode())
                .description(product.getDescription())
                .unitPriceHT(product.getUnitPriceHT())
                .rateTVA(product.getRateTVA())
                .unitPriceTTC(product.getUnitPriceTTC())
                .picture(product.getPicture())
                .category(CategoryDto.fromEntity(product.getCategory()))
                .build();
    }
    public static Product toEntity(ProductDto productDto){
        if(productDto==null)
        return null;
        Product product=new Product();
        product.setId(productDto.getId());
        product.setCode(productDto.getCode());
        product.setDescription(productDto.getDescription());
        product.setUnitPriceHT(productDto.getUnitPriceHT());
        product.setRateTVA(productDto.getRateTVA());
        product.setUnitPriceTTC(productDto.getUnitPriceTTC());
        product.setPicture(productDto.getPicture());
        product.setCategory(CategoryDto.toEntity(productDto.getCategory()));
        return product;
    }
}
