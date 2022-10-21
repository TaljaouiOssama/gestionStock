package com.ossama.gestionstock.repository;

import com.ossama.gestionstock.dto.ClientOrderDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientOrderRepository extends JpaRepository<Integer, ClientOrderDto>{
}
