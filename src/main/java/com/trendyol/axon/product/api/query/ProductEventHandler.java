package com.trendyol.axon.product.api.query;

import com.trendyol.axon.product.api.core.domain.Product;
import com.trendyol.axon.product.api.core.event.ProductCreatedEvent;
import com.trendyol.axon.product.api.query.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductEventHandler {
    private final ProductRepository productRepository;
    @EventHandler
    public void on(ProductCreatedEvent productCreatedEvent) {
        productRepository.save(Product.create(productCreatedEvent));
    }
}
