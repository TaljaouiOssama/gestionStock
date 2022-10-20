package com.ossama.gestionstock.model;

import lombok.*;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
public class Entreprise extends AbstractEntity{
    private String name;
    private String description;
    @Embedded
    private Address address;
    private String taxCode;
    private String picture;
    private String email;
    private String phone;
    private String website;
    @OneToMany(mappedBy = "entreprise")
    private List<Users> usersList;

}
