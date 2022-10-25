package com.ossama.gestionstock.service;

import com.ossama.gestionstock.dto.SupplierOrderDto;
import com.ossama.gestionstock.dto.SupplierOrderLineDto;

import java.util.List;

public interface SupplierOrderService {
    SupplierOrderDto addSupplierOrder(SupplierOrderDto supplierOrderDto);
    SupplierOrderDto addLinesToSupplierOrder(Integer id, List<SupplierOrderLineDto> supplierOrderLineDtoList);
    SupplierOrderDto removeLinesToSupplierOrder(Integer id, List<SupplierOrderLineDto> supplierOrderLineDtoList);
    SupplierOrderDto getSupplierOrderById(Integer id);
    SupplierOrderDto getSupplierOrderByCode(String code);
    List<SupplierOrderDto> getAllSupplierOrders();
    SupplierOrderDto updateSupplierOrder(Integer id,SupplierOrderDto supplierOrderDto);
    SupplierOrderDto deleteSupplierOrder(Integer id);
}
