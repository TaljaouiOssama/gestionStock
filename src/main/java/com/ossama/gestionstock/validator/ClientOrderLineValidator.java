package com.ossama.gestionstock.validator;

import com.ossama.gestionstock.dto.ClientOrderLineDto;

import java.util.ArrayList;
import java.util.List;

public class ClientOrderLineValidator {
    public static List<String> validate(ClientOrderLineDto clientOrderLineDto) {
        List<String> errors = new ArrayList<>();
        if(clientOrderLineDto==null)
            errors.add("clientOrderLineDto is NULL");
        return errors;
    }
}
