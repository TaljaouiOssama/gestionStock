package com.ossama.gestionstock.repository;

import com.ossama.gestionstock.dto.SalesDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesRepository extends JpaRepository<Integer, SalesDto> {
}
