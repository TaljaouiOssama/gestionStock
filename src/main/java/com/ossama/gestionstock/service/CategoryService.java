package com.ossama.gestionstock.service;

import com.ossama.gestionstock.dto.CategoryDto;

import java.util.List;

public interface CategoryService {
    CategoryDto addCategory(CategoryDto categoryDto);
    CategoryDto getCategoryById(Integer id);
    CategoryDto getCategoryByCode(String code);
    List<CategoryDto> getAllCategories();
    CategoryDto updateCategory(Integer id,CategoryDto categoryDto);
    CategoryDto deleteCategory(Integer id);
}
