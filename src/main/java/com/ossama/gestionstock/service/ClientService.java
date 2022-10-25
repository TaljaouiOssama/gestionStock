package com.ossama.gestionstock.service;

import com.ossama.gestionstock.dto.ClientDto;

import java.util.List;

public interface ClientService {
    ClientDto addClient(ClientDto clientDto);
    ClientDto getClientById(Integer id);
    ClientDto getClientByCode(String code);
    List<ClientDto> getAllClients();
    ClientDto updateClient(Integer id,ClientDto clientDto);
    ClientDto deleteClient(Integer id);

    
}
