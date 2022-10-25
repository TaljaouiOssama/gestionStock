package com.ossama.gestionstock.repository;


import com.ossama.gestionstock.model.Sales;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SalesRepository extends JpaRepository<Sales,Integer> {
    Optional<Sales> findSalesByCode(String code);
}
