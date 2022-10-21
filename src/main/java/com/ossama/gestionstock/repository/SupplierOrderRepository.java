package com.ossama.gestionstock.repository;


import com.ossama.gestionstock.dto.SupplierOrderDto;
import com.ossama.gestionstock.model.SupplierOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierOrderRepository extends JpaRepository<SupplierOrder,Integer> {
}
