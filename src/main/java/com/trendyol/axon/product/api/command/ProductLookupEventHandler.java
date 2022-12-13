package com.trendyol.axon.product.api.command;

import com.trendyol.axon.product.api.common.Constants;
import com.trendyol.axon.product.api.core.domain.ProductLookup;
import com.trendyol.axon.product.api.core.event.ProductCreatedEvent;
import com.trendyol.axon.product.api.core.repository.ProductLookupRepository;
import lombok.RequiredArgsConstructor;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.eventhandling.ResetHandler;
import org.springframework.stereotype.Component;

@Component
@ProcessingGroup(Constants.Group.PRODUCT)
@RequiredArgsConstructor
public class ProductLookupEventHandler {
    private final ProductLookupRepository productLookupRepository;

    @EventHandler
    public void on(ProductCreatedEvent productCreatedEvent) {
        productLookupRepository.save(ProductLookup.create(productCreatedEvent));
    }

    @ResetHandler
    public void reset() {
        productLookupRepository.deleteAll();
    }
}
