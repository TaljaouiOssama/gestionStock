package com.ossama.gestionstock.validator;

import com.ossama.gestionstock.dto.AddressDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class AddressValidator {
    public static List<String> validate(AddressDto addressDto){
        List<String> errors=new ArrayList<>();
        if(addressDto==null)
            errors.add("AddressDto is NULL");
        if(!StringUtils.hasLength(addressDto.getAddress1()))
            errors.add("Address1 is mandatory");
        if(addressDto.getAddress1().length()<10 || addressDto.getAddress1().length()>30)
            errors.add("Address1 min length =>10 Address1 max length =>30");
        if(!StringUtils.hasLength(addressDto.getCity()))
            errors.add("City is mandatory");
        if(addressDto.getCity().length()<2 || addressDto.getCity().length()>30)
            errors.add("City min length =>2 City max length =>30");
        return errors;
    }


}
