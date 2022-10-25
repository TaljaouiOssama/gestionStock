package com.ossama.gestionstock.service.Impl;

import com.ossama.gestionstock.dto.ClientOrderDto;
import com.ossama.gestionstock.dto.ClientOrderLineDto;
import com.ossama.gestionstock.exception.EntityNotFoundException;
import com.ossama.gestionstock.exception.ErrorsCode;
import com.ossama.gestionstock.exception.InvalidEntityException;
import com.ossama.gestionstock.model.Client;
import com.ossama.gestionstock.model.ClientOrder;
import com.ossama.gestionstock.model.Product;
import com.ossama.gestionstock.repository.ClientOrderRepository;
import com.ossama.gestionstock.repository.ClientRepository;
import com.ossama.gestionstock.repository.ProductRepository;
import com.ossama.gestionstock.service.ClientOrderService;
import com.ossama.gestionstock.validator.ClientOrderValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ClientOrderServiceImpl implements ClientOrderService {
    ClientRepository clientRepository;

    ClientOrderRepository clientOrderRepository;
    ProductRepository productRepository;
    @Autowired
    public ClientOrderServiceImpl(ClientRepository clientRepository,ClientOrderRepository clientOrderRepository,ProductRepository productRepository) {
        this.clientRepository = clientRepository;
        this.clientOrderRepository=clientOrderRepository;
        this.productRepository=productRepository;
    }

    @Override
    @Transactional
    public ClientOrderDto addClientOrder(ClientOrderDto clientOrderDto) {
        List<String> errors= ClientOrderValidator.validate(clientOrderDto);
        if(!errors.isEmpty()){
            log.error("add: clientOrderDto is not valid",clientOrderDto);
            throw new InvalidEntityException("clientOrderDto is not valid", ErrorsCode.ClientOrder_Not_Valid,errors);
        }
        Optional<Client> client=clientRepository.findById(clientOrderDto.getClient().getId());
        if(!client.isPresent()){
            log.error("client With id {} is not present",clientOrderDto.getClient().getId());
            throw new EntityNotFoundException("client With id "+clientOrderDto.getClient().getId()+" is not Found",ErrorsCode.Client_Not_Found);
        }
        client.get().getClientOrderList().add(ClientOrderDto.toEntity(clientOrderDto));
        clientRepository.save(client.get());


        return ClientOrderDto.fromEntity(
                clientOrderRepository.save(
                        ClientOrderDto.toEntity(clientOrderDto)
                )
        );
    }

    @Override
    public ClientOrderDto addLinesToClientOrder(Integer id, List<ClientOrderLineDto> clientOrderLineDtoList) {
        if(id==null){
            log.error("get: clientOrderId is null");
            return null;
        }
        Optional<ClientOrder> clientOrder=clientOrderRepository.findById(id);
        if(!clientOrder.isPresent()){
            throw new EntityNotFoundException("clientOrder with id "+id+" not found",ErrorsCode.ClientOrder_Not_Found);
        }
        clientOrderLineDtoList.forEach( clientOrderLine ->{
            if(clientOrderLine!=null){
                Optional<Product> product=productRepository.findById(clientOrderLine.getProduct().getId());
                if(!product.isPresent()){
                    log.error("product With id {} is not present",clientOrderLine.getProduct().getId());
                    throw new EntityNotFoundException("product With id "+clientOrderLine.getProduct().getId()+" is not Found",ErrorsCode.Product_Not_Found);
                }
                product.get().getClientOrderLineList().add(ClientOrderLineDto.toEntity(clientOrderLine));
                productRepository.save(product.get());
            }
        } );
        clientOrder.get().getClientOrderLineList().addAll(
                clientOrderLineDtoList.stream().map(ClientOrderLineDto::toEntity).collect(Collectors.toList()));

        return ClientOrderDto.fromEntity(
                clientOrderRepository.save(clientOrder.get()));

    }

    @Override
    @Transactional
    public ClientOrderDto removeLinesToClientOrder(Integer id, List<ClientOrderLineDto> clientOrderLineDtoList) {
        if(id==null){
            log.error("get: clientOrderId is null");
            return null;
        }
        Optional<ClientOrder> clientOrder=clientOrderRepository.findById(id);
        if(!clientOrder.isPresent()){
            throw new EntityNotFoundException("clientOrder with id "+id+" not found",ErrorsCode.ClientOrder_Not_Found);
        }
        clientOrderLineDtoList.forEach( clientOrderLine ->{
            if(clientOrderLine!=null){
                Optional<Product> product=productRepository.findById(clientOrderLine.getProduct().getId());
                if(!product.isPresent()){
                    log.error("product With id {} is not present",clientOrderLine.getProduct().getId());
                    throw new EntityNotFoundException("product With id "+clientOrderLine.getProduct().getId()+" is not Found",ErrorsCode.Product_Not_Found);
                }
                product.get().getClientOrderLineList().remove(ClientOrderLineDto.toEntity(clientOrderLine));
                productRepository.save(product.get());
            }
        } );
        clientOrder.get().getClientOrderLineList().removeAll(
                clientOrderLineDtoList.stream().map(ClientOrderLineDto::toEntity).collect(Collectors.toList()));

        return ClientOrderDto.fromEntity(
                clientOrderRepository.save(clientOrder.get()));
    }

    @Override
    public ClientOrderDto getClientOrderById(Integer id) {
        if(id==null){
            log.error("get: clientOrderId is null");
            return null;
        }
        return clientOrderRepository.findById(id).map(ClientOrderDto::fromEntity).orElseThrow(
                ()->new EntityNotFoundException("clientOrder with id "+id+" not found",ErrorsCode.ClientOrder_Not_Found)
        );
    }

    @Override
    public ClientOrderDto getClientOrderByCode(String code) {
        if(code==null){
            log.error("get: clientOrderCode is null");
            return null;
        }
        return clientOrderRepository.findClientOrderByCode(code).map(ClientOrderDto::fromEntity).orElseThrow(
                ()->new EntityNotFoundException("clientOrder with code "+code+" not found",ErrorsCode.ClientOrder_Not_Found)
        );
    }

    @Override
    public List<ClientOrderDto> getAllClientOrders() {
        return clientOrderRepository.findAll()
                .stream()
                .map(ClientOrderDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public ClientOrderDto updateClientOrder(Integer id, ClientOrderDto clientOrderDto) {
        List<String> errors= ClientOrderValidator.validate(clientOrderDto);
        if(!errors.isEmpty()){
            log.error("add: clientOrderDto is not valid",clientOrderDto);
            throw new InvalidEntityException("clientOrderDto is not valid", ErrorsCode.ClientOrder_Not_Valid,errors);
        }
        if(id==null){
            log.error("update: clientOrderId is null");
            return null;
        }
        Optional<ClientOrder> clientOrder=clientOrderRepository.findById(id);
        if(!clientOrder.isPresent()){
            log.error("clientOrder with id "+id+" not found");
            throw new EntityNotFoundException("clientOrder with id "+id+" not found",ErrorsCode.ClientOrder_Not_Found);
        }
        Optional<Client> client=clientRepository.findById(clientOrderDto.getClient().getId());
        if(!client.isPresent()){
            log.error("client With id {} is not present",clientOrderDto.getClient().getId());
            throw new EntityNotFoundException("client With id "+clientOrderDto.getClient().getId()+" is not Found",ErrorsCode.Client_Not_Found);
        }
        client.get().getClientOrderList().add(ClientOrderDto.toEntity(clientOrderDto));
        client.get().getClientOrderList().remove(clientOrder.get());
        clientRepository.save(client.get());
        clientOrder.get().setClient(client.get());
        clientOrder.get().setOrderDate(clientOrderDto.getOrderDate());
        clientOrder.get().setCode(clientOrderDto.getCode());
        return ClientOrderDto.fromEntity(
                clientOrderRepository.save(clientOrder.get())
        );
    }

    @Override
    @Transactional
    public ClientOrderDto deleteClientOrder(Integer id) {
        if(id==null){
            log.error("delete: clientOrderId is null");
            return null;
        }
        Optional<ClientOrder> clientOrder=clientOrderRepository.findById(id);
        if(!clientOrder.isPresent()){
            log.error("clientOrder with id "+id+" not found");
            throw new EntityNotFoundException("clientOrder with id "+id+" not found",ErrorsCode.ClientOrder_Not_Found);
        }
        Optional<Client> client=clientRepository.findById(clientOrder.get().getClient().getId());
        if(!client.isPresent()){
            log.error("client With id {} is not present",clientOrder.get().getClient().getId());
            throw new EntityNotFoundException("client With id "+clientOrder.get().getClient().getId()+" is not Found",ErrorsCode.Client_Not_Found);
        }
        client.get().getClientOrderList().remove(clientOrder.get());
        clientRepository.save(client.get());
        clientOrderRepository.deleteById(id);
        return ClientOrderDto.fromEntity(clientOrder.get());
    }
}
