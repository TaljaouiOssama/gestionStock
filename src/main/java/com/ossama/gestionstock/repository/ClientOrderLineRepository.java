package com.ossama.gestionstock.repository;

import com.ossama.gestionstock.dto.ClientOrderLineDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientOrderLineRepository extends JpaRepository<Integer, ClientOrderLineDto> {
}
