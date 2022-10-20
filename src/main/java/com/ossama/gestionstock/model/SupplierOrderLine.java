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

public class SupplierOrderLine extends AbstractEntity {
    private String code;
    @ManyToOne
    @JoinColumn(name="supplierOrderId")
    private SupplierOrder supplierOrder;
    @ManyToOne
    @JoinColumn(name="productId")
    private Product product;
}
