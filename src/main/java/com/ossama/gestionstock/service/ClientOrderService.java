package com.ossama.gestionstock.service;

import com.ossama.gestionstock.dto.ClientOrderDto;
import com.ossama.gestionstock.dto.ClientOrderLineDto;

import java.util.List;

public interface ClientOrderService {
    ClientOrderDto addClientOrder(ClientOrderDto clientOrderDto);
    ClientOrderDto addLinesToClientOrder(Integer id, List<ClientOrderLineDto> clientOrderLineDtoList);
    ClientOrderDto removeLinesToClientOrder(Integer id, List<ClientOrderLineDto> clientOrderLineDtoList);
    ClientOrderDto getClientOrderById(Integer id);
    ClientOrderDto getClientOrderByCode(String code);
    List<ClientOrderDto> getAllClientOrders();
    ClientOrderDto updateClientOrder(Integer id,ClientOrderDto clientOrderDto);
    ClientOrderDto deleteClientOrder(Integer id);

}
