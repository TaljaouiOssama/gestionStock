package com.ossama.gestionstock.controller.api.impl;

import com.ossama.gestionstock.controller.api.ClientOrderApi;
import com.ossama.gestionstock.dto.ClientOrderDto;
import com.ossama.gestionstock.service.ClientOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class ClientOrderApiImpl implements ClientOrderApi {
    private ClientOrderService clientOrderService;
    @Autowired
    public ClientOrderApiImpl(ClientOrderService clientOrderService){
        this.clientOrderService=clientOrderService;
    }
    @Override
    public ClientOrderDto saveClientOrder(ClientOrderDto clientOrderDto) {
        return this.clientOrderService.addClientOrder(clientOrderDto);
    }

    @Override
    public ClientOrderDto findClientOrderById(Integer clientOrderId) {
        return this.clientOrderService.getClientOrderById(clientOrderId);
    }

    @Override
    public ClientOrderDto findClientOrderByCode(String clientOrderCode) {
        return this.clientOrderService.getClientOrderByCode(clientOrderCode);
    }

    @Override
    public List<ClientOrderDto> findAllClientOrders() {
        return this.clientOrderService.getAllClientOrders();
    }

    @Override
    public ClientOrderDto deleteClientOrderById(Integer clientOrderId) {
        return this.clientOrderService.deleteClientOrder(clientOrderId);
    }
}
