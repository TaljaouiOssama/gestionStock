package com.ossama.gestionstock.validator;

import com.ossama.gestionstock.dto.StockMovementDto;

import java.util.ArrayList;
import java.util.List;

public class StockMovementValidator {
    public static List<String> validate(StockMovementDto stockMovementDto) {
        List<String> errors = new ArrayList<>();
        if(stockMovementDto==null)
            errors.add("StockMovementDto is NULL");
        return errors;
    }
}
