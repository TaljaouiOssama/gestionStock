package com.ossama.gestionstock.validator;

import com.ossama.gestionstock.dto.SalesDto;

import java.util.ArrayList;
import java.util.List;

public class SalesValidator {
    public static List<String> validate(SalesDto salesDto) {
        List<String> errors = new ArrayList<>();
        if(salesDto==null)
            errors.add("SalesDto is NULL");
        return errors;
    }
}
