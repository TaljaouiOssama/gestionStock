package com.ossama.gestionstock.repository;


import com.ossama.gestionstock.dto.SupplierOrderDto;
import com.ossama.gestionstock.model.ClientOrder;
import com.ossama.gestionstock.model.SupplierOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SupplierOrderRepository extends JpaRepository<SupplierOrder,Integer> {
    Optional<SupplierOrder> findSupplierOrderByCode(String code);
}
