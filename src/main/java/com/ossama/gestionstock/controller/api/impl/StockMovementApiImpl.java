package com.ossama.gestionstock.controller.api.impl;

import com.ossama.gestionstock.controller.api.StockMovementApi;
import com.ossama.gestionstock.dto.StockMovementDto;
import com.ossama.gestionstock.service.StockMovementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class StockMovementApiImpl implements StockMovementApi {
    private StockMovementService stockMovementService;
    @Autowired
    public StockMovementApiImpl(StockMovementService stockMovementService) {
        this.stockMovementService = stockMovementService;
    }

    @Override
    public StockMovementDto saveStockMovement(StockMovementDto stockMovementDto) {
        return this.stockMovementService.addStockMovement(stockMovementDto);
    }

    @Override
    public StockMovementDto findStockMovementById(Integer stockMovementId) {
        return this.stockMovementService.getStockMovementById(stockMovementId);
    }

    @Override
    public StockMovementDto findStockMovementByCode(String stockMovementCode) {
        return this.stockMovementService.getStockMovementByCode(stockMovementCode);
    }

    @Override
    public List<StockMovementDto> findAllStockMovements() {
        return this.stockMovementService.getAllStockMovements();
    }

    @Override
    public StockMovementDto deleteStockMovementById(Integer stockMovementId) {
        return this.stockMovementService.deleteStockMovement(stockMovementId);
    }
}
