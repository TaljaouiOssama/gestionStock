package com.ossama.gestionstock.repository;


import com.ossama.gestionstock.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer>{
}
