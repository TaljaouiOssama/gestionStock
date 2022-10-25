package com.ossama.gestionstock.service;

import com.ossama.gestionstock.dto.SupplierDto;

import java.util.List;

public interface SupplierService {
    SupplierDto addSupplier(SupplierDto supplierDto);
    SupplierDto getSupplierById(Integer id);
    SupplierDto getSupplierByCode(String code);
    List<SupplierDto> getAllSuppliers();
    SupplierDto updateSupplier(Integer id,SupplierDto supplierDto);
    SupplierDto deleteSupplier(Integer id);
}
