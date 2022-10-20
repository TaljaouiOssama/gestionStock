package com.ossama.gestionstock.dto;


import com.ossama.gestionstock.model.SupplierOrderLine;
import lombok.Builder;
import lombok.Data;



@Data
@Builder
public class SupplierOrderLineDto {
    private Integer id;
    private String code;
    private SupplierOrderDto supplierOrder;
    private ProductDto product;
    public static SupplierOrderLineDto fromEntity(SupplierOrderLine supplierOrderLine){
        if(supplierOrderLine==null)
            return null;
        return SupplierOrderLineDto.builder()
                .id(supplierOrderLine.getId())
                .code(supplierOrderLine.getCode())
                .supplierOrder(SupplierOrderDto.fromEntity(supplierOrderLine.getSupplierOrder()))
                .product(ProductDto.fromEntity(supplierOrderLine.getProduct()))
                .build();
    }
    public static SupplierOrderLine toEntity(SupplierOrderLineDto supplierOrderLineDto){
        if(supplierOrderLineDto==null)
            return null;
        SupplierOrderLine supplierOrderLine= new SupplierOrderLine();
        supplierOrderLine.setId(supplierOrderLineDto.getId());
        supplierOrderLine.setCode(supplierOrderLineDto.getCode());
        supplierOrderLine.setSupplierOrder(SupplierOrderDto.toEntity(supplierOrderLineDto.getSupplierOrder()));
        supplierOrderLine.setProduct(ProductDto.toEntity(supplierOrderLineDto.getProduct()));
        return supplierOrderLine;
    }
}
