package com.ossama.gestionstock.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ossama.gestionstock.model.Users;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

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
    public static UsersDto fromEntity(Users users){
        if(users==null)
        return null;
        return UsersDto.builder()
                .id(users.getId())
                .firstName(users.getFirstName())
                .lastName(users.getLastName())
                .picture(users.getPicture())
                .email(users.getEmail())
                .address(AddressDto.fromEntity(users.getAddress()))
                .password(users.getPassword())
                .phone(users.getPhone())
                .rolesList(users.getRolesList()!=null
                        ?users.getRolesList().stream().map(RolesDto::fromEntity).collect(Collectors.toList())
                        :null)
                .build();
    }
    public static Users toEntity(UsersDto usersDto){
        if(usersDto==null)
        return null;
        Users users=new Users();
        users.setId(usersDto.getId());
        users.setFirstName(usersDto.getFirstName());
        users.setLastName(usersDto.getLastName());
        users.setPicture(usersDto.getPicture());
        users.setEmail(usersDto.getEmail());
        users.setAddress(AddressDto.toEntity(usersDto.getAddress()));
        users.setRolesList(usersDto.getRolesList()!=null
                ?usersDto.getRolesList().stream().map(RolesDto::toEntity).collect(Collectors.toList())
                :null);
        users.setPassword(usersDto.getPassword());
        users.setPhone(usersDto.getPhone());
        return users;
    }
}
