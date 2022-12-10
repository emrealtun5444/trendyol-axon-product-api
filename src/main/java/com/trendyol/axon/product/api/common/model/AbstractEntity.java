package com.trendyol.axon.product.api.common.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@RequiredArgsConstructor
@SuperBuilder
@MappedSuperclass
public abstract class AbstractEntity implements Serializable {

    @Id
    @Column(name = "id", nullable = false, unique = true)
    private String id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date lastModifiedDate;

    @PreUpdate
    public void preUpdate() {
        this.lastModifiedDate = new Date();
    }

    @PrePersist
    public void prePersist() {
        this.createdDate = new Date();
        this.lastModifiedDate = new Date();
    }

}
