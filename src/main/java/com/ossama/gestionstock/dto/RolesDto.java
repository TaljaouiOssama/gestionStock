package com.ossama.gestionstock.dto;


import com.ossama.gestionstock.model.Roles;
import lombok.Builder;
import lombok.Data;



@Data
@Builder
public class RolesDto {
    private Integer id;
    private String code;
    private String name;
    private UsersDto user;
    public static RolesDto fromEntity(Roles roles){
        if(roles==null)
            return null;
        return RolesDto.builder()
                .id(roles.getId())
                .code(roles.getCode())
                .name(roles.getName())
                .user(UsersDto.fromEntity(roles.getUser()))
                .build();
    }
    public static Roles toEntity(RolesDto rolesDto){
        if(rolesDto==null)
            return null;
        Roles roles=new Roles();
        roles.setId(rolesDto.getId());
        roles.setCode(rolesDto.getCode());
        roles.setName(rolesDto.getName());
        roles.setUser(UsersDto.toEntity(rolesDto.getUser()));
        return roles;
    }
}
