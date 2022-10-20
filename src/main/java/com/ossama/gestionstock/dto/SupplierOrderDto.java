package com.ossama.gestionstock.dto;

import com.ossama.gestionstock.model.SupplierOrder;
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
    public static SupplierOrderDto fromEntity(SupplierOrder supplierOrder){
        if(supplierOrder==null)
            return null;
        return SupplierOrderDto.builder()
                .id(supplierOrder.getId())
                .code(supplierOrder.getCode())
                .orderDate(supplierOrder.getOrderDate())
                .supplier(SupplierDto.fromEntity(supplierOrder.getSupplier()))
                .build();
    }
    public static SupplierOrder toEntity(SupplierOrderDto supplierOrderDto){
        if(supplierOrderDto==null)
            return null;
        SupplierOrder supplierOrder=new SupplierOrder();
        supplierOrder.setId(supplierOrderDto.getId());
        supplierOrder.setCode(supplierOrderDto.getCode());
        supplierOrder.setOrderDate(supplierOrderDto.getOrderDate());
        supplierOrder.setSupplier(SupplierDto.toEntity(supplierOrderDto.getSupplier()));
        return supplierOrder;

    }
}
