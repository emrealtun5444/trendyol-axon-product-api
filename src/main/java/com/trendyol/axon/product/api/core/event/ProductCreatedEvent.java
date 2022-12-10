package com.trendyol.axon.product.api.core.event;

import com.trendyol.axon.product.api.command.CreateProductCommand;
import com.trendyol.axon.product.api.common.BaseEvent;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@SuperBuilder
@Getter
public class ProductCreatedEvent extends BaseEvent<String> {
    private String title;
    private String brand;
    private String category;
    private String description;
    private BigDecimal price;
    private Integer quantity;

    public static ProductCreatedEvent create(CreateProductCommand createProductCommand) {
        return ProductCreatedEvent.builder()
                .id(createProductCommand.id)
                .price(createProductCommand.getPrice())
                .title(createProductCommand.getTitle())
                .quantity(createProductCommand.getQuantity())
                .brand(createProductCommand.getBrand())
                .category(createProductCommand.getCategory())
                .description(createProductCommand.getDescription())
                .build();
    }
}
