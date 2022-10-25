package com.ossama.gestionstock.repository;

import com.ossama.gestionstock.dto.SupplierDto;
import com.ossama.gestionstock.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SupplierRepository extends JpaRepository<Supplier,Integer> {
    Optional<Supplier> findSupplierByCode(String code);
}
