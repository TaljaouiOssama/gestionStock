package com.ossama.gestionstock.service.Impl;

import com.ossama.gestionstock.dto.ClientDto;
import com.ossama.gestionstock.exception.EntityNotFoundException;
import com.ossama.gestionstock.exception.ErrorsCode;
import com.ossama.gestionstock.exception.InvalidEntityException;
import com.ossama.gestionstock.model.Client;
import com.ossama.gestionstock.repository.ClientRepository;
import com.ossama.gestionstock.service.ClientService;
import com.ossama.gestionstock.validator.ClientValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ClientServiceImpl implements ClientService {

    private ClientRepository clientRepository;
    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public ClientDto addClient(ClientDto clientDto) {
       List<String> errors= ClientValidator.validate(clientDto);
       if(!errors.isEmpty()){
           log.error("clientDto is Not Valid",clientDto);
           throw new InvalidEntityException("clientDto is Not Valid", ErrorsCode.Client_Not_Valid,errors);
       }
       return ClientDto.fromEntity(
               clientRepository.save(ClientDto.toEntity(clientDto))
       );
    }

    @Override
    public ClientDto getClientById(Integer id) {
        if(id==null){
            log.error("get: ClientID is NULL");
            return null;
        }
        Optional<Client> client=clientRepository.findById(id);
        return client.map(ClientDto::fromEntity)
                .orElseThrow(
                        ()->new EntityNotFoundException("Client with id"+id+" Not found",ErrorsCode.Client_Not_Found));
    }

    @Override
    public ClientDto getClientByCode(String code) {
        if(code==null){
            log.error("get ClientCode is NULL");
            return null;
        }
        Optional<Client> client=clientRepository.findClientByCode(code);
        return client.map(ClientDto::fromEntity)
                .orElseThrow(()->new EntityNotFoundException("Client with code"+code+" Not found",ErrorsCode.Client_Not_Found));

    }

    @Override
    public List<ClientDto> getAllClients() {
        return clientRepository.findAll().stream()
                .map(ClientDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public ClientDto updateClient(Integer id, ClientDto clientDto) {
        List<String> errors= ClientValidator.validate(clientDto);
        if(!errors.isEmpty()){
            log.error("clientDto is Not Valid",clientDto);
            throw new InvalidEntityException("clientDto is Not Valid", ErrorsCode.Client_Not_Valid,errors);
        }

        if(id==null){
            log.error("update ClientId is NULL");
            return null;
        }
        Optional<Client> client=clientRepository.findById(id);
        if(client.isPresent()){
            client.get().setFirstName(clientDto.getFirstName());
            client.get().setLastName(clientDto.getLastName());
            client.get().setPhone(clientDto.getPhone());
            client.get().setEmail(clientDto.getEmail());
            client.get().setPicture(clientDto.getPicture());
            clientRepository.save(client.get());
        }
        return clientRepository.findById(id).map(ClientDto::fromEntity)
                .orElseThrow(()->new EntityNotFoundException("Client with id "+id+"not found",ErrorsCode.Client_Not_Found));
    }

    @Override
    public ClientDto deleteClient(Integer id) {
        if(id==null){
            log.error("delete: Client with id NULL");
            return null;
        }
        Optional<Client> client=clientRepository.findById(id);
        if(client.isPresent()){
            clientRepository.deleteById(id);
            return ClientDto.fromEntity(client.get());
        }
        throw new EntityNotFoundException("client with id "+id+" not found",ErrorsCode.Client_Not_Found);

    }
}
