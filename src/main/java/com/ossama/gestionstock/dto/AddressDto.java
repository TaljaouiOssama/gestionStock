package com.ossama.gestionstock.dto;

import com.ossama.gestionstock.model.Address;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddressDto {
    private String address1;
    private String address2;
    private String city;
    private String zipCode;
    private String country;
    private AddressDto fromEntity(Address address){
        if(address==null){
            return null;

        }
        return AddressDto.builder()
                .address1(address.getAddress1())
                .address2(address.getAddress2())
                .city(address.getCity())
                .zipCode(address.getZipCode())
                .country(address.getCountry())
                .build();
    }
}
