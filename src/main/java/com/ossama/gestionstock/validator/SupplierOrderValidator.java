package com.ossama.gestionstock.validator;

import com.ossama.gestionstock.dto.SupplierOrderDto;

import java.util.ArrayList;
import java.util.List;

public class SupplierOrderValidator {
    public static List<String> validate(SupplierOrderDto supplierOrderDto) {
        List<String> errors = new ArrayList<>();
        if(supplierOrderDto==null)
            errors.add("SupplierOrderDto is NULL");

        return errors;
    }
}
