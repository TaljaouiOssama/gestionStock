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
public class Client extends AbstractEntity{
    private String firstName;
    private String lastName;
    private String picture;
    @Embedded
    private Address address;
    private String email;
    private String phone;
    @OneToMany(mappedBy = "client")
    private List<ClientOrder> clientOrderList;

}