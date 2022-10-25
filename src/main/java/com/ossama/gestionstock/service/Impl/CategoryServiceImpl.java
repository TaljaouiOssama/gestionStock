package com.ossama.gestionstock.service.Impl;

import com.ossama.gestionstock.dto.CategoryDto;
import com.ossama.gestionstock.exception.EntityNotFoundException;
import com.ossama.gestionstock.exception.ErrorsCode;
import com.ossama.gestionstock.exception.InvalidEntityException;
import com.ossama.gestionstock.model.Category;
import com.ossama.gestionstock.repository.CategoryRepository;
import com.ossama.gestionstock.service.CategoryService;
import com.ossama.gestionstock.validator.CategoryValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepository categoryRepository;
    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository){
        this.categoryRepository=categoryRepository;
    }
    @Override
    public CategoryDto addCategory(CategoryDto categoryDto) {
        List<String> errors=CategoryValidator.validate(categoryDto);
        if(!errors.isEmpty()){// we got errors
            log.error("Category is not Valid",categoryDto);
            throw new InvalidEntityException("Category is not Valid", ErrorsCode.Category_Not_Valid,errors);
        }
        return CategoryDto.fromEntity(
                categoryRepository.save(
                    CategoryDto.toEntity(categoryDto)
                )
            );
    }

    @Override
    public CategoryDto getCategoryById(Integer id) {
        if(id==null){
            log.error("id is NULL");
            return null;
        }
        Optional<Category> category= categoryRepository.findById(id) ;
        return category.map(CategoryDto::fromEntity)
                .orElseThrow(
                ()->new EntityNotFoundException("Category Not Found with id"+id,ErrorsCode.Category_Not_Found)
                );
    }

    @Override
    public CategoryDto getCategoryByCode(String code) {
        if(code==null){
            log.error("code is NULL");
            return null;
        }
        Optional<Category> category= categoryRepository.findCategoryByCode(code) ;
        return category.map(CategoryDto::fromEntity)
                .orElseThrow(
                    ()->new EntityNotFoundException("Category Not Found with id"+code,ErrorsCode.Category_Not_Found)
                );
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        return categoryRepository
                .findAll()
                .stream()
                .map(CategoryDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDto updateCategory(Integer id, CategoryDto categoryDto) {
        if(id==null){
            log.error("id is NULL");
            return null;
        }
        List<String> errors=CategoryValidator.validate(categoryDto);
        if(!errors.isEmpty()){// we got errors
            log.error("Category is not Valid",categoryDto);
            throw new InvalidEntityException("Category is not Valid", ErrorsCode.Category_Not_Valid,errors);
        }
        Optional<Category> category= categoryRepository.findById(id) ;
       if (category.isPresent()){
           category.get().setCode(categoryDto.getCode());
           category.get().setDescription(categoryDto.getDescription());
           categoryRepository.save(category.get());
       }
        return categoryRepository.findById(id).map(CategoryDto::fromEntity)
                .orElseThrow(
                        ()->new EntityNotFoundException("Category Not Found with id"+id,ErrorsCode.Category_Not_Found)
                );
    }

    @Override
    public CategoryDto deleteCategory(Integer id) {
        if(id==null){
            log.error("id is NULL");
            return null;
        }
        Optional<Category> category= categoryRepository.findById(id) ;
        if(!category.isPresent())
            throw new EntityNotFoundException("Category Not Found with id"+id,ErrorsCode.Category_Not_Found);
        categoryRepository.deleteById(id);
        return CategoryDto.fromEntity(category.get());

    }
}
