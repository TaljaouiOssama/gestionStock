package com.ossama.gestionstock.repository;


import com.ossama.gestionstock.model.Sales;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesRepository extends JpaRepository<Sales,Integer> {
}
