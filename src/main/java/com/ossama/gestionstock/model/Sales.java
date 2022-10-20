package com.ossama.gestionstock.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.time.Instant;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
public class Sales extends AbstractEntity{
    private String code;
    private Instant salesDate;
    @OneToMany(mappedBy = "sales")
    private List<SalesLine> salesLineList;
}
