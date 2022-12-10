package com.trendyol.axon.product.api.domain;

import com.trendyol.axon.product.api.common.model.AbstractEntity;
import com.trendyol.axon.product.api.event.ProductCreatedEvent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Getter
@SuperBuilder
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

    public static Product create(ProductCreatedEvent productCreatedEvent) {
        return Product.builder()
                .price(productCreatedEvent.getPrice())
                .quantity(productCreatedEvent.getQuantity())
                .title(productCreatedEvent.getTitle())
                .id(productCreatedEvent.getId())
                .build();
    }

}