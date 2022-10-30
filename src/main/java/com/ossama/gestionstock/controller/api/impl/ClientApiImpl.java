package com.ossama.gestionstock.controller.api.impl;

import com.ossama.gestionstock.controller.api.ClientApi;
import com.ossama.gestionstock.dto.ClientDto;
import com.ossama.gestionstock.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class ClientApiImpl implements ClientApi {
    private  ClientService clientService;
    @Autowired
    public ClientApiImpl(ClientService clientService){
        this.clientService=clientService;
    }
    @Override
    public ClientDto saveClient(ClientDto clientDto) {
        return clientService.addClient(clientDto);
    }

    @Override
    public ClientDto findClientById(Integer clientId) {
        return clientService.getClientById(clientId);
    }

    @Override
    public ClientDto findClientByCode(String clientCode) {
        return clientService.getClientByCode(clientCode);
    }

    @Override
    public List<ClientDto> findAllClients() {
        return clientService.getAllClients();
    }

    @Override
    public ClientDto deleteClientById(Integer clientId) {
        return clientService.deleteClient(clientId);
    }
}
