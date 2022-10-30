package com.ossama.gestionstock.controller.api;

import com.ossama.gestionstock.dto.SupplierOrderDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.ossama.gestionstock.other.Constants.SUPPLIER_ORDER_API;

public interface SupplierOrderApi {
    @PostMapping(value = SUPPLIER_ORDER_API+"/save",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    SupplierOrderDto saveSupplierOrder(@RequestBody SupplierOrderDto supplierOrderDto);
    @GetMapping(value=SUPPLIER_ORDER_API+"/{supplierOrderId}",produces = MediaType.APPLICATION_JSON_VALUE)
    SupplierOrderDto findSupplierOrderById(@PathVariable Integer supplierOrderId);
    @GetMapping(value=SUPPLIER_ORDER_API+"/{supplierOrderCode}",produces = MediaType.APPLICATION_JSON_VALUE)
    SupplierOrderDto findSupplierOrderByCode(@PathVariable String supplierOrderCode);
    @GetMapping(value=SUPPLIER_ORDER_API+"/all",produces = MediaType.APPLICATION_JSON_VALUE)
    List<SupplierOrderDto> findAllSupplierOrders();
    @DeleteMapping(value = SUPPLIER_ORDER_API+"/delete/{supplierOrderId}",produces = MediaType.APPLICATION_JSON_VALUE)
    SupplierOrderDto deleteSupplierOrderById(@PathVariable Integer supplierOrderId);
}
