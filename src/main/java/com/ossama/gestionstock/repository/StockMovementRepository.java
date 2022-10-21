package com.ossama.gestionstock.repository;

import com.ossama.gestionstock.dto.StockMovementDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockMovementRepository extends JpaRepository<Integer, StockMovementDto>{
}
