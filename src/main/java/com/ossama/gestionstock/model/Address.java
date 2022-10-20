package com.ossama.gestionstock.model;

import lombok.*;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
@Embeddable

public class Address implements Serializable {
    private String address1;
    private String address2;
    private String city;
    private String zipCode;
    private String Country;
}
