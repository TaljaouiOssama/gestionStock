package com.ossama.gestionstock.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity

public class StockMovement extends AbstractEntity{
    private String code;
    private Instant mvtDate;
    private BigDecimal quantity;
    private TypeMvtStk type;
    @ManyToOne
    @JoinColumn(name="productId")
    private Product product;
}
