package com.ossama.gestionstock.repository;

import com.ossama.gestionstock.dto.SupplierDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Integer, SupplierDto> {
}
