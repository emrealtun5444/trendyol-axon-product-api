package com.trendyol.axon.product.api.event;

import com.trendyol.axon.product.api.common.BaseEvent;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@SuperBuilder
@Getter
public class ProductCreatedEvent extends BaseEvent<String> {
    private String title;
    private BigDecimal price;
    private Integer quantity;
}
