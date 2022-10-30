package com.ossama.gestionstock.controller.api;

import com.ossama.gestionstock.dto.CategoryDto;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.ossama.gestionstock.other.Constants.CATEGORY_API;



public interface CategoryApi {
    @PostMapping(value=CATEGORY_API+"/save",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    CategoryDto saveCategory( @RequestBody CategoryDto categoryDto);

    @GetMapping (value=CATEGORY_API+"/{categoryId}", produces = MediaType.APPLICATION_JSON_VALUE)
    CategoryDto findCategoryById(@PathVariable  Integer categoryId);
    @GetMapping(value=CATEGORY_API+"/{categoryCode}",produces = MediaType.APPLICATION_JSON_VALUE)
    CategoryDto findCategoryByCode(@PathVariable String categoryCode);

    @GetMapping(value=CATEGORY_API+"/all",produces = MediaType.APPLICATION_JSON_VALUE)
    List<CategoryDto> findAllCategories();
    @DeleteMapping(value=CATEGORY_API+"/delete/{categoryId}",produces = MediaType.APPLICATION_JSON_VALUE)
    CategoryDto deleteCategoryById( @PathVariable  Integer categoryId);
}
