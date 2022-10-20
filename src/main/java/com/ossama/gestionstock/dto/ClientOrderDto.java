package com.ossama.gestionstock.dto;

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
    private List<ClientOrderLineDto> clientOrderLineList;
    private ClientDto client;
}
