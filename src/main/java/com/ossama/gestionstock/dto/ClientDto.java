package com.ossama.gestionstock.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ClientDto {
    private Integer id;
    private String firstName;
    private String lastName;
    private String picture;
    private AddressDto address;
    private String email;
    private String phone;
    private List<ClientOrderDto> clientOrderList;
}
