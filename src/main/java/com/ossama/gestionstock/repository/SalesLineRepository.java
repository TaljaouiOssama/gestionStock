package com.ossama.gestionstock.repository;

import com.ossama.gestionstock.dto.SalesLineDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesLineRepository extends JpaRepository<Integer, SalesLineDto>{
}
