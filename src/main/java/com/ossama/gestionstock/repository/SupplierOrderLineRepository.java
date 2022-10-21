package com.ossama.gestionstock.repository;

import com.ossama.gestionstock.dto.SupplierOrderLineDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierOrderLineRepository extends JpaRepository<Integer, SupplierOrderLineDto>{
}
