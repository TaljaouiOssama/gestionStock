package com.ossama.gestionstock.repository;


import com.ossama.gestionstock.model.Entreprise;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EntrepriseRepository extends JpaRepository<Entreprise,Integer>{

    Optional<Entreprise> findEntrepriseByCode(String code);
}
