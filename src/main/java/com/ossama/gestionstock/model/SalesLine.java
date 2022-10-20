package com.ossama.gestionstock.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
public class SalesLine extends AbstractEntity{
    private String code;
    private BigDecimal quantity;

    @ManyToOne
    @JoinColumn(name="salesId")
    private Sales sales;
    @ManyToOne
    @JoinColumn(name="productId")
    private Product product;
}

