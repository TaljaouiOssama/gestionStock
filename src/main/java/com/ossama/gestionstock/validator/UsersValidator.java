package com.ossama.gestionstock.validator;

import com.ossama.gestionstock.dto.UsersDto;

import java.util.ArrayList;
import java.util.List;

public class UsersValidator {
    public static List<String> validate(UsersDto usersDto) {
        List<String> errors = new ArrayList<>();
        if(usersDto==null)
            errors.add("UsersDto is NULL");
        errors.addAll(AddressValidator.validate(usersDto.getAddress()));
        return errors;
    }
}
