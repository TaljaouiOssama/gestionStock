package com.ossama.gestionstock.dto;

import com.ossama.gestionstock.model.Address;
import com.ossama.gestionstock.model.SupplierOrder;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Embedded;
import javax.persistence.OneToMany;
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
    private List<SupplierOrderDto> supplierOrderList;
}
