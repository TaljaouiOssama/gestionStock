package com.ossama.gestionstock.controller.api;

import com.ossama.gestionstock.dto.ClientDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.ossama.gestionstock.other.Constants.CLIENT_API;

public interface ClientApi {
    @PostMapping(value=CLIENT_API+"/save",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    ClientDto saveClient(@RequestBody  ClientDto clientDto);

    @GetMapping(value=CLIENT_API+"/{clientId}", produces = MediaType.APPLICATION_JSON_VALUE)
    ClientDto findClientById(@PathVariable Integer clientId);
    @GetMapping(value=CLIENT_API+"/{clientCode}",produces = MediaType.APPLICATION_JSON_VALUE)
    ClientDto findClientByCode(@PathVariable String clientCode);

    @GetMapping(value=CLIENT_API+"/all",produces = MediaType.APPLICATION_JSON_VALUE)
    List<ClientDto> findAllClients();
    @DeleteMapping(value=CLIENT_API+"/delete/{clientId}",produces = MediaType.APPLICATION_JSON_VALUE)
    ClientDto deleteClientById( @PathVariable  Integer clientId);
}
