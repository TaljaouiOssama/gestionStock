package com.ossama.gestionstock.repository;


import com.ossama.gestionstock.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
