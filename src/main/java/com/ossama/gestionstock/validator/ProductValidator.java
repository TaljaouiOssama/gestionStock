package com.ossama.gestionstock.validator;

import com.ossama.gestionstock.dto.ProductDto;

import java.util.ArrayList;
import java.util.List;

public class ProductValidator {
    public static List<String> validate(ProductDto productDto) {
        List<String> errors = new ArrayList<>();
        if(productDto==null)
            errors.add("ProductDto is NULL");
        return errors;
    }
}
