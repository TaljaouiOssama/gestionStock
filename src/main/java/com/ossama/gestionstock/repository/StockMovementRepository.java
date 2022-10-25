package com.ossama.gestionstock.repository;

import com.ossama.gestionstock.dto.StockMovementDto;
import com.ossama.gestionstock.model.StockMovement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StockMovementRepository extends JpaRepository<StockMovement,Integer>{
    Optional<StockMovement> findStockMovementByCode(String code);
}
