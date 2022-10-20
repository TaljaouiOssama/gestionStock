package com.ossama.gestionstock.dto;

import com.ossama.gestionstock.model.ClientOrderLine;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClientOrderLineDto {
    private Integer id;
    private String code;
    private ClientOrderDto clientOrder;
    private ProductDto product;
    public static ClientOrderLineDto fromEntity(ClientOrderLine clientOrderLine){
        if(clientOrderLine==null)
            return null;
        return ClientOrderLineDto.builder()
                .id(clientOrderLine.getId())
                .code(clientOrderLine.getCode())
                .clientOrder(ClientOrderDto.fromEntity(clientOrderLine.getClientOrder()))
                .product(ProductDto.fromEntity(clientOrderLine.getProduct()))
                .build();
    }
    public static ClientOrderLine toEntity(ClientOrderLineDto clientOrderLineDto){
        if(clientOrderLineDto==null)
            return null;
        ClientOrderLine clientOrderLine= new ClientOrderLine();
        clientOrderLine.setId(clientOrderLineDto.getId());
        clientOrderLine.setCode(clientOrderLineDto.getCode());
        clientOrderLine.setClientOrder(ClientOrderDto.toEntity(clientOrderLineDto.getClientOrder()));
        clientOrderLine.setProduct(ProductDto.toEntity(clientOrderLineDto.getProduct()));
        return clientOrderLine;
    }
}
