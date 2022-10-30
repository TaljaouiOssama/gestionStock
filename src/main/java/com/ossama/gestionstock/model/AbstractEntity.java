package com.ossama.gestionstock.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class AbstractEntity implements Serializable{
    @Id
    @GeneratedValue
    private Integer id;
    @CreatedDate
    @Column(nullable = false,updatable = false)
    @JsonIgnore
    private Instant CreatedDate;
    @LastModifiedDate
    @JsonIgnore
    private Instant LastModifiedDate;
}
