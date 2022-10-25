package com.ossama.gestionstock.service;

import com.ossama.gestionstock.dto.StockMovementDto;

import java.util.List;

public interface StockMovementService {
    StockMovementDto addStockMovement(StockMovementDto stockMovementDto);
    StockMovementDto getStockMovementById(Integer id);
    StockMovementDto getStockMovementByCode(String code);
    List<StockMovementDto> getAllStockMovements();
    StockMovementDto updateStockMovement(Integer id,StockMovementDto stockMovementDto);
    StockMovementDto deleteStockMovement(Integer id);
}
