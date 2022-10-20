package com.ossama.gestionstock.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Entity

public class Category extends AbstractEntity{
    private String code;
    private String description;
    @OneToMany(mappedBy = "category")
    private List<Product> productList;

}
