package com.ossama.gestionstock.repository;


import com.ossama.gestionstock.model.SalesLine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesLineRepository extends JpaRepository<SalesLine,Integer>{
}
