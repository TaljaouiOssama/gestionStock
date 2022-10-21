package com.ossama.gestionstock.validator;

import com.ossama.gestionstock.dto.ClientOrderDto;

import java.util.ArrayList;
import java.util.List;

public class ClientOrderValidator {
    public static List<String> validate(ClientOrderDto clientOrderDto) {
        List<String> errors = new ArrayList<>();
        if(clientOrderDto==null)
            errors.add("clientOrderDto is NULL");
        return errors;
    }
}
