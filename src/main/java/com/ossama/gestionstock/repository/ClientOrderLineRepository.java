package com.ossama.gestionstock.repository;


import com.ossama.gestionstock.model.ClientOrderLine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientOrderLineRepository extends JpaRepository<ClientOrderLine,Integer> {
}
