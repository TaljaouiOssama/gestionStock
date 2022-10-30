package com.ossama.gestionstock.controller.api.impl;

import com.ossama.gestionstock.controller.api.SupplierApi;
import com.ossama.gestionstock.dto.SupplierDto;
import com.ossama.gestionstock.service.SupplierService;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class SupplierApiImpl implements SupplierApi {
    private SupplierService supplierService;

    public SupplierApiImpl(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @Override
    public SupplierDto saveSupplier(SupplierDto supplierDto) {
        return this.supplierService.addSupplier(supplierDto);
    }

    @Override
    public SupplierDto findSupplierById(Integer supplierId) {
        return this.supplierService.getSupplierById(supplierId);
    }

    @Override
    public SupplierDto findSupplierByCode(String supplierCode) {
        return this.supplierService.getSupplierByCode(supplierCode);
    }

    @Override
    public List<SupplierDto> findAllSuppliers() {
        return this.supplierService.getAllSuppliers();
    }

    @Override
    public SupplierDto deleteSupplierById(Integer supplierId) {
        return this.supplierService.deleteSupplier(supplierId);
    }
}
