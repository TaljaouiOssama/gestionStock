package com.ossama.gestionstock.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ossama.gestionstock.model.Client;
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
    @JsonIgnore
    private List<ClientOrderDto> clientOrderList;

    public static ClientDto fromEntity(Client client){
        if(client==null)
            return null;
        return ClientDto.builder()
                .id(client.getId())
                .firstName(client.getFirstName())
                .lastName(client.getLastName())
                .picture(client.getPicture())
                .address(AddressDto.fromEntity(client.getAddress()))
                .email(client.getEmail())
                .phone(client.getPhone())
                .build();

    }
    public static Client toEntity(ClientDto clientDto){
        if(clientDto==null)
            return null;
        Client client=new Client();
        client.setId(clientDto.getId());
        client.setFirstName(clientDto.getFirstName());
        client.setLastName(clientDto.getLastName());
        client.setPicture(clientDto.getPicture());
        client.setAddress(AddressDto.toEntity(clientDto.getAddress()));
        client.setEmail(clientDto.getEmail());
        client.setPhone(clientDto.getPhone());
        return client;
    }
}
