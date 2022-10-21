package com.ossama.gestionstock.validator;

import com.ossama.gestionstock.dto.ClientDto;

import java.util.ArrayList;
import java.util.List;

public class ClientValidator {
    public static List<String> validate(ClientDto clientDto) {
        List<String> errors = new ArrayList<>();
        if(clientDto==null)
            errors.add("clientDto is NULL");
        errors.addAll(AddressValidator.validate(clientDto.getAddress()));
        return errors;
    }
}
