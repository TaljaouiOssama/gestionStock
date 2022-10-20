package com.ossama.gestionstock.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
public class ClientOrderLine extends AbstractEntity{
    private String code;
    @ManyToOne
    @JoinColumn(name="clientOrderId")
    private ClientOrder clientOrder;
    @ManyToOne
    @JoinColumn(name="productId")
    private Product product;
}
