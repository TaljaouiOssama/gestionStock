package com.ossama.gestionstock.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity

public class Users extends AbstractEntity{
    private String firstName;
    private String lastName;
    private String picture;
    private String email;
    @Embedded
    private Address address;
    private String password;
    private String phone;
    @OneToMany
    private List<Roles> rolesList;
    @ManyToOne
    @JoinColumn(name = "entrepriseId")
    private Entreprise entreprise;
}
