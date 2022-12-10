package com.trendyol.axon.product.api.query.service;

import com.trendyol.axon.product.api.query.FindProductQuery;
import com.trendyol.axon.product.api.query.repository.ProductRepository;
import com.trendyol.axon.product.api.query.rest.ProductResponseModel;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductQueryHandler {
    private final ProductRepository productRepository;
    @QueryHandler
    public List<ProductResponseModel> findAllProduct(FindProductQuery findProductQuery) {
        return productRepository.findAllProduct();
    }
}
