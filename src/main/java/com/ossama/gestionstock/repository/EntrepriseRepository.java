package com.ossama.gestionstock.repository;

import com.ossama.gestionstock.dto.EntrepriseDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntrepriseRepository extends JpaRepository<Integer, EntrepriseDto>{
}
