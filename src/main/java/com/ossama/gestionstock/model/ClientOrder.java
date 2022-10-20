package com.ossama.gestionstock.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.Instant;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
public class ClientOrder extends AbstractEntity{
    private String code;
    private Instant orderDate;
    @OneToMany(mappedBy = "clientOrder")
    private List<ClientOrderLine> clientOrderLineList;
    @ManyToOne
    @JoinColumn(name = "idClient")
    private Client client;
}
