package com.trendyol.axon.product.api.core.domain;

import com.trendyol.axon.product.api.common.model.AbstractEntity;
import com.trendyol.axon.product.api.core.event.ProductCreatedEvent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class ProductLookup extends AbstractEntity {

    @Column
    private String barcode;

    public static ProductLookup create(ProductCreatedEvent productCreatedEvent) {
        return ProductLookup.builder()
                .barcode(productCreatedEvent.getBarcode())
                .id(productCreatedEvent.getId())
                .build();
    }

}