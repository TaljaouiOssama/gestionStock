package com.ossama.gestionstock.controller.api.impl;

import com.ossama.gestionstock.controller.api.SupplierOrderApi;
import com.ossama.gestionstock.dto.SupplierOrderDto;
import com.ossama.gestionstock.service.SupplierOrderService;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class SupplierOrderApiImpl implements SupplierOrderApi {
    private SupplierOrderService supplierOrderService;

    public SupplierOrderApiImpl(SupplierOrderService supplierOrderService) {
        this.supplierOrderService = supplierOrderService;
    }

    @Override
    public SupplierOrderDto saveSupplierOrder(SupplierOrderDto supplierOrderDto) {
        return this.supplierOrderService.addSupplierOrder(supplierOrderDto);
    }

    @Override
    public SupplierOrderDto findSupplierOrderById(Integer supplierOrderId) {
        return this.supplierOrderService.getSupplierOrderById(supplierOrderId);
    }

    @Override
    public SupplierOrderDto findSupplierOrderByCode(String supplierOrderCode) {
        return this.supplierOrderService.getSupplierOrderByCode(supplierOrderCode);
    }

    @Override
    public List<SupplierOrderDto> findAllSupplierOrders() {
        return this.supplierOrderService.getAllSupplierOrders();
    }

    @Override
    public SupplierOrderDto deleteSupplierOrderById(Integer supplierOrderId) {
        return this.supplierOrderService.deleteSupplierOrder(supplierOrderId);
    }
}
