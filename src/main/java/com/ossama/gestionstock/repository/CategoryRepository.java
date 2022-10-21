package com.ossama.gestionstock.repository;

import com.ossama.gestionstock.dto.CategoryDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Integer, CategoryDto> {
}
