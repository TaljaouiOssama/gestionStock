package com.ossama.gestionstock.repository;

import com.ossama.gestionstock.dto.ProductDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Integer, ProductDto>{
}
