package com.ossama.gestionstock.controller.api;

import com.ossama.gestionstock.dto.ClientOrderDto;
import com.ossama.gestionstock.dto.ClientOrderLineDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.ossama.gestionstock.other.Constants.CLIENT_ORDER_API;

public interface ClientOrderApi {
    @PostMapping(value = CLIENT_ORDER_API+"/save",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    ClientOrderDto saveClientOrder(@RequestBody ClientOrderDto clientOrderDto);
    @GetMapping(value=CLIENT_ORDER_API+"/{clientOrderId}",produces = MediaType.APPLICATION_JSON_VALUE)
    ClientOrderDto findClientOrderById(@PathVariable Integer clientOrderId);
    @GetMapping(value=CLIENT_ORDER_API+"/{clientOrderCode}",produces = MediaType.APPLICATION_JSON_VALUE)
    ClientOrderDto findClientOrderByCode(@PathVariable String clientOrderCode);
    @GetMapping(value=CLIENT_ORDER_API+"/all",produces = MediaType.APPLICATION_JSON_VALUE)
    List<ClientOrderDto> findAllClientOrders();
    @DeleteMapping (value=CLIENT_ORDER_API+"/delete/{clientOrderId}",produces = MediaType.APPLICATION_JSON_VALUE)
    ClientOrderDto deleteClientOrderById(@PathVariable Integer clientOrderId);
}
