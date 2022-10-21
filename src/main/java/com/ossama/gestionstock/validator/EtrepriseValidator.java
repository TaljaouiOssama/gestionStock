package com.ossama.gestionstock.validator;

import com.ossama.gestionstock.dto.EntrepriseDto;

import java.util.ArrayList;
import java.util.List;

public class EtrepriseValidator {
    public static List<String> validate(EntrepriseDto entrepriseDto) {
        List<String> errors = new ArrayList<>();
        if(entrepriseDto==null)
            errors.add("EntrepriseDto is NULL");
        errors.addAll(AddressValidator.validate(entrepriseDto.getAddress()));
        return errors;
    }
}
