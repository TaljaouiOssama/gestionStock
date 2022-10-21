package com.ossama.gestionstock.validator;

import com.ossama.gestionstock.dto.RolesDto;

import java.util.ArrayList;
import java.util.List;

public class RolesValidator {
    public static List<String> validate(RolesDto rolesDto) {
        List<String> errors = new ArrayList<>();
        if(rolesDto==null)
            errors.add("RolesDto is NULL");
        return errors;
    }
}
