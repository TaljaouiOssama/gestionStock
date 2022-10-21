package com.ossama.gestionstock.repository;

import com.ossama.gestionstock.dto.ClientOrderDto;
import com.ossama.gestionstock.model.ClientOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientOrderRepository extends JpaRepository<ClientOrder,Integer>{
}
