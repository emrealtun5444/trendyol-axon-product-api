package com.trendyol.axon.product.api.domain;

import com.trendyol.axon.product.api.common.model.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Product extends AbstractEntity {

    @Column
    private String title;

    @Column
    private BigDecimal price;

    @Column
    private Integer quantity;

}