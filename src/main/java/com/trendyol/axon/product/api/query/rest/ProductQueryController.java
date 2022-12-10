package com.trendyol.axon.product.api.query.rest;

import com.trendyol.axon.product.api.query.FindProductQuery;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/products")
public class ProductQueryController {
    private final QueryGateway queryGateway;
    @GetMapping
    public List<ProductResponseModel> getProducts() {
        final var findProductQuery = FindProductQuery.builder().build();
        return queryGateway.query(findProductQuery, ResponseTypes.multipleInstancesOf(ProductResponseModel.class)).join();
    }
}
