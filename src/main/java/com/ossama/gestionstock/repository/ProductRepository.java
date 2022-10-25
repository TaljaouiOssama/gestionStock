package com.ossama.gestionstock.repository;


import com.ossama.gestionstock.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Integer>{
    Optional<Product> findProductByCode(String code);
}
