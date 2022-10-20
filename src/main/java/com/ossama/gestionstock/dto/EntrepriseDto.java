package com.ossama.gestionstock.dto;


import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class EntrepriseDto {
    private Integer id;
    private String name;
    private String description;
    private AddressDto address;
    private String taxCode;
    private String picture;
    private String email;
    private String phone;
    private String website;
    private List<UsersDto> usersList;
}
