package com.ossama.gestionstock.controller.api.impl;

import com.ossama.gestionstock.controller.api.CategoryApi;
import com.ossama.gestionstock.dto.CategoryDto;
import com.ossama.gestionstock.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;



@RestController

public class CategoryApiImpl implements CategoryApi {
    private CategoryService categoryService;

    @Autowired
    public CategoryApiImpl(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override

    public CategoryDto saveCategory(CategoryDto categoryDto) {
        return categoryService.addCategory(categoryDto);
    }

    @Override
    public CategoryDto findCategoryById(Integer categoryId) {
        return categoryService.getCategoryById(categoryId);
    }

    @Override
    public CategoryDto findCategoryByCode(String categoryCode) {
        return categoryService.getCategoryByCode(categoryCode);
    }

    @Override
    public List<CategoryDto> findAllCategories() {
        return categoryService.getAllCategories();
    }

    @Override
    public CategoryDto deleteCategoryById(Integer categoryId) {

        return categoryService.deleteCategory(categoryId);
    }
}
