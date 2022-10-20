package com.ossama.gestionstock.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ossama.gestionstock.model.ClientOrder;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@Data
@Builder
public class ClientOrderDto {
    private Integer id;
    private String code;
    private Instant orderDate;
    @JsonIgnore
    private List<ClientOrderLineDto> clientOrderLineList;
    private ClientDto client;
    public static ClientOrderDto fromEntity(ClientOrder clientOrder){
        if(clientOrder==null)
            return null;
        return ClientOrderDto.builder()
                .id(clientOrder.getId())
                .code(clientOrder.getCode())
                .orderDate(clientOrder.getOrderDate())
                .client(ClientDto.fromEntity(clientOrder.getClient()))
                .build();
    }
    public static ClientOrder toEntity(ClientOrderDto clientOrderDto){
        if(clientOrderDto==null)
            return null;
        ClientOrder clientOrder=new ClientOrder();
        clientOrder.setId(clientOrderDto.getId());
        clientOrder.setCode(clientOrderDto.getCode());
        clientOrder.setOrderDate(clientOrderDto.getOrderDate());
        clientOrder.setClient(ClientDto.toEntity(clientOrderDto.getClient()));
        return clientOrder;

    }
}
