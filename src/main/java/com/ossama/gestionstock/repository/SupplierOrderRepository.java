package com.ossama.gestionstock.repository;


import com.ossama.gestionstock.dto.SupplierOrderDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierOrderRepository extends JpaRepository<Integer, SupplierOrderDto> {
}
