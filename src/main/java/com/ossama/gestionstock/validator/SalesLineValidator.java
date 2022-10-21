package com.ossama.gestionstock.validator;

import com.ossama.gestionstock.dto.SalesLineDto;

import java.util.ArrayList;
import java.util.List;

public class SalesLineValidator {
    public static List<String> validate(SalesLineDto salesLineDto) {
        List<String> errors = new ArrayList<>();
        if(salesLineDto==null)
            errors.add("SalesLineDto is NULL");
        return errors;
    }
}
