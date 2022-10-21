package com.ossama.gestionstock.repository;


import com.ossama.gestionstock.model.SupplierOrderLine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierOrderLineRepository extends JpaRepository<SupplierOrderLine,Integer>{
}
