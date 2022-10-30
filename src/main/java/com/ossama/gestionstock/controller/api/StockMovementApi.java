package com.ossama.gestionstock.controller.api;

import com.ossama.gestionstock.dto.StockMovementDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.ossama.gestionstock.other.Constants.STOCK_MOVEMENT_API;

public interface StockMovementApi {
    @PostMapping(value =STOCK_MOVEMENT_API+"/save",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    StockMovementDto saveStockMovement(@RequestBody StockMovementDto stockMovementDto);
    @GetMapping(value = STOCK_MOVEMENT_API+"/{stockMovementId}",produces = MediaType.APPLICATION_JSON_VALUE)
    StockMovementDto findStockMovementById(@PathVariable Integer stockMovementId);
    @GetMapping(value = STOCK_MOVEMENT_API+"/{stockMovementCode}",produces = MediaType.APPLICATION_JSON_VALUE)
    StockMovementDto findStockMovementByCode(@PathVariable String stockMovementCode);
    @GetMapping(value = STOCK_MOVEMENT_API+"/all",produces = MediaType.APPLICATION_JSON_VALUE)
    List<StockMovementDto> findAllStockMovements();
    @DeleteMapping(value = STOCK_MOVEMENT_API+"/delete/{stockMovementId}",produces = MediaType.APPLICATION_JSON_VALUE)
    StockMovementDto deleteStockMovementById(@PathVariable Integer stockMovementId);
}
