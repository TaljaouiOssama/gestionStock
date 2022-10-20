package com.ossama.gestionstock.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
public class Product extends AbstractEntity{
    private String code;
    private String description;
    private BigDecimal unitPriceHT;
    private BigDecimal rateTVA;
    private BigDecimal unitPriceTTC;
    private String picture;
    @ManyToOne
    @JoinColumn(name = "idCategory")
    private Category category;
    @OneToMany(mappedBy = "product")
    private List<ClientOrderLine> clientOrderLineList;
    @OneToMany(mappedBy = "product")
    private List<SupplierOrderLine> supplierOrderLineList;
    @OneToMany(mappedBy = "product")
    private List<SalesLine> salesLineList;
    @OneToMany(mappedBy = "product")
    private List<StockMovement> stockMovementList;
}
