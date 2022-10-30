package com.ossama.gestionstock.controller.api.impl;

import com.ossama.gestionstock.controller.api.SalesApi;
import com.ossama.gestionstock.dto.SalesDto;
import com.ossama.gestionstock.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class SalesApiImpl implements SalesApi {
    private SalesService salesService;
    @Autowired
    public SalesApiImpl(SalesService salesService) {
        this.salesService = salesService;
    }

    @Override
    public SalesDto saveSales(SalesDto salesDto) {
        return this.salesService.addSales(salesDto);
    }

    @Override
    public SalesDto findSalesById(Integer salesId) {
        return this.salesService.getSalesById(salesId);
    }

    @Override
    public SalesDto findSalesByCode(String salesCode) {
        return this.salesService.getSalesByCode(salesCode);
    }

    @Override
    public List<SalesDto> findAllSales() {
        return this.salesService.getAllSales();
    }

    @Override
    public SalesDto deleteSalesById(Integer salesId) {
        return this.salesService.deleteSales(salesId);
    }
}
