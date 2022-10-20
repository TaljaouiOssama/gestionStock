package com.ossama.gestionstock.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import com.ossama.gestionstock.model.Supplier;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class SupplierDto {
    private Integer id;
    private String firstName;
    private String lastName;
    private String picture;
    private AddressDto address;
    private String email;
    private String phone;
    @JsonIgnore
    private List<SupplierOrderDto> supplierOrderList;
    public static SupplierDto fromEntity(Supplier supplier){
        if(supplier==null)
            return null;
        return SupplierDto.builder()
                .id(supplier.getId())
                .firstName(supplier.getFirstName())
                .lastName(supplier.getLastName())
                .picture(supplier.getPicture())
                .address(AddressDto.fromEntity(supplier.getAddress()))
                .email(supplier.getEmail())
                .phone(supplier.getPhone())
                .build();

    }
    public static Supplier toEntity(SupplierDto supplierDto){
        if(supplierDto==null)
            return null;
        Supplier supplier=new Supplier();
        supplier.setId(supplierDto.getId());
        supplier.setFirstName(supplierDto.getFirstName());
        supplier.setLastName(supplierDto.getLastName());
        supplier.setPicture(supplierDto.getPicture());
        supplier.setAddress(AddressDto.toEntity(supplierDto.getAddress()));
        supplier.setEmail(supplierDto.getEmail());
        supplier.setPhone(supplierDto.getPhone());
        return supplier;
    }
}
