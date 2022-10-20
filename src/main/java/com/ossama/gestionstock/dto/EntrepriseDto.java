package com.ossama.gestionstock.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ossama.gestionstock.model.Entreprise;
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
    @JsonIgnore
    private List<UsersDto> usersList;
    public static EntrepriseDto fromEntity(Entreprise entreprise){
        if(entreprise==null)
            return null;
        return EntrepriseDto.builder()
                .id(entreprise.getId())
                .name(entreprise.getName())
                .description(entreprise.getDescription())
                .address(AddressDto.fromEntity(entreprise.getAddress()))
                .taxCode(entreprise.getTaxCode())
                .picture(entreprise.getPicture())
                .email(entreprise.getEmail())
                .phone(entreprise.getPhone())
                .website(entreprise.getWebsite())
                .build();
    }
    public static Entreprise toEntity(EntrepriseDto entrepriseDto){
        if(entrepriseDto==null)
            return null;
        Entreprise entreprise=new Entreprise();
        entreprise.setId(entrepriseDto.getId());
        entreprise.setName(entrepriseDto.getName());
        entreprise.setDescription(entrepriseDto.getDescription());
        entreprise.setAddress(AddressDto.toEntity(entrepriseDto.getAddress()));
        entreprise.setTaxCode(entrepriseDto.getTaxCode());
        entreprise.setEmail(entrepriseDto.getEmail());
        entreprise.setPhone(entrepriseDto.getPhone());
        entreprise.setWebsite(entreprise.getWebsite());
        return entreprise;
    }
}
