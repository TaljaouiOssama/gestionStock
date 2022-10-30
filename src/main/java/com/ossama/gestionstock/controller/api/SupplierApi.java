package com.ossama.gestionstock.controller.api;

import com.ossama.gestionstock.dto.SupplierDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.ossama.gestionstock.other.Constants.SUPPLIER_API;

public interface SupplierApi {
    @PostMapping(value = SUPPLIER_API+"/save",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    SupplierDto saveSupplier(@RequestBody SupplierDto supplierDto);
    @GetMapping(value = SUPPLIER_API+"/{supplierId}",produces = MediaType.APPLICATION_JSON_VALUE)
    SupplierDto findSupplierById(@PathVariable Integer supplierId);
    @GetMapping(value = SUPPLIER_API+"/{supplierCode}",produces = MediaType.APPLICATION_JSON_VALUE)
    SupplierDto findSupplierByCode(@PathVariable String supplierCode);
    @GetMapping(value = SUPPLIER_API+"/all",produces = MediaType.APPLICATION_JSON_VALUE)
    List<SupplierDto> findAllSuppliers();
    @DeleteMapping (value = SUPPLIER_API+"/delete/{supplierId}",produces = MediaType.APPLICATION_JSON_VALUE)
    SupplierDto deleteSupplierById(@PathVariable Integer supplierId);
}
