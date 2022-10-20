package com.ossama.gestionstock.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UsersDto {
    private Integer id;
    private String firstName;
    private String lastName;
    private String picture;
    private String email;
    private AddressDto address;
    private String password;
    private String phone;
    private List<RolesDto> rolesList;
    private EntrepriseDto entreprise;
}
