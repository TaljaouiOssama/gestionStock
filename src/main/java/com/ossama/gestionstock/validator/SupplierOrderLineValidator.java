package com.ossama.gestionstock.validator;

import com.ossama.gestionstock.dto.SupplierOrderLineDto;

import java.util.ArrayList;
import java.util.List;

public class SupplierOrderLineValidator {
    public static List<String> validate(SupplierOrderLineDto supplierOrderLineDto) {
        List<String> errors = new ArrayList<>();
        if(supplierOrderLineDto==null)
            errors.add("SupplierOrderLineDto is NULL");
        return errors;
    }
}
