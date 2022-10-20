package com.ossama.gestionstock.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ossama.gestionstock.model.Category;
import lombok.Builder;
import lombok.Data;


import java.util.List;

@Data
@Builder
public class CategoryDto {
    private Integer id;
    private String code;
    private String description;
    @JsonIgnore
    private List<ProductDto> productList;

    public static CategoryDto fromEntity(Category category){
        if(category==null){
            return null;
            //TODO Throw Exception
        }
        return CategoryDto.builder()
                .id(category.getId())
                .code(category.getCode())
                .description(category.getDescription())
                .build();
    }
    public static Category toEntity(CategoryDto categoryDto){
        if(categoryDto==null){
            return null;
            //TODO Throw Exception
        }
        Category category=new Category();
        category.setId(categoryDto.getId());
        category.setCode(categoryDto.getCode());
        category.setDescription(categoryDto.getDescription());
        return category;
    }
}
