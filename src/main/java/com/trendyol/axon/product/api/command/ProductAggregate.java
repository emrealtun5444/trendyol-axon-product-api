package com.trendyol.axon.product.api.command;

import com.trendyol.axon.product.api.common.exception.BusinessException;
import com.trendyol.axon.product.api.core.event.ProductCreatedEvent;
import liquibase.util.StringUtils;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import java.math.BigDecimal;

@NoArgsConstructor
@Aggregate
public class ProductAggregate {
    @AggregateIdentifier
    private String id;
    private String title;
    private String brand;
    private String category;
    private String description;
    private BigDecimal price;
    private Integer quantity;

    @CommandHandler
    public ProductAggregate(CreateProductCommand createProductCommand) {
        if (createProductCommand.getQuantity() < 0) {
            throw new BusinessException("Quantity can not be less then 0");
        }
        if (createProductCommand.getPrice().compareTo(BigDecimal.ZERO) < 0) {
            throw new BusinessException("Price can not be less then 0");
        }
        if (StringUtils.isEmpty(createProductCommand.getCategory())) {
            throw new BusinessException("Category can not be empty");
        }
        if (StringUtils.isEmpty(createProductCommand.getBrand())) {
            throw new BusinessException("Brand can not be empty");
        }

        final var productCreatedEvent = ProductCreatedEvent.create(createProductCommand);

        AggregateLifecycle.apply(productCreatedEvent);
    }

    @EventSourcingHandler
    public void on(ProductCreatedEvent productCreatedEvent) {
        this.id = productCreatedEvent.getId();
        this.price = productCreatedEvent.getPrice();
        this.quantity = productCreatedEvent.getQuantity();
        this.title = productCreatedEvent.getTitle();
        this.brand = productCreatedEvent.getBrand();
        this.category = productCreatedEvent.getCategory();
        this.description = productCreatedEvent.getDescription();
    }

}
