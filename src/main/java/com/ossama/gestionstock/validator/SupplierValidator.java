package com.ossama.gestionstock.validator;

import com.ossama.gestionstock.dto.SupplierDto;

import java.util.ArrayList;
import java.util.List;

public class SupplierValidator {
    public static List<String> validate(SupplierDto supplierDto) {
        List<String> errors = new ArrayList<>();
        if(supplierDto==null)
            errors.add("SupplierDto is NULL");
        errors.addAll(AddressValidator.validate(supplierDto.getAddress()));
        return errors;
    }
}
