package com.ossama.gestionstock.validator;


import com.ossama.gestionstock.dto.CategoryDto;

import java.util.ArrayList;
import java.util.List;

public class CategoryValidator {
    public static List<String> validate(CategoryDto categoryDto) {
        List<String> errors = new ArrayList<>();
        if(categoryDto==null)
            errors.add("CategoryDto is NULL");
        return errors;
    }
}
