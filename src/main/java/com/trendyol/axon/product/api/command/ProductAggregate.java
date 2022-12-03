package com.trendyol.axon.product.api.command;

import com.trendyol.axon.product.api.event.ProductCreatedEvent;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;

@NoArgsConstructor
@Aggregate
public class ProductAggregate {
    @AggregateIdentifier
    public String id;
    private String title;
    private BigDecimal price;
    private Integer quantity;

    @CommandHandler
    public ProductAggregate(CreateProductCommand createProductCommand) {
        if (createProductCommand.getQuantity() < 0) {
            throw new IllegalArgumentException("Quantity can not be less then 0");
        }
        if (createProductCommand.getPrice().compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Price can not be less then 0");
        }

        final var productCreatedEvent = ProductCreatedEvent.builder()
                .id(createProductCommand.id)
                .price(createProductCommand.getPrice())
                .title(createProductCommand.getTitle())
                .quantity(createProductCommand.getQuantity())
                .build();

        AggregateLifecycle.apply(productCreatedEvent);
    }

    @EventSourcingHandler
    public void on(ProductCreatedEvent productCreatedEvent) {
        this.id = productCreatedEvent.getId();
        this.price = productCreatedEvent.getPrice();
        this.quantity = productCreatedEvent.getQuantity();
        this.title = productCreatedEvent.getTitle();
    }

}
