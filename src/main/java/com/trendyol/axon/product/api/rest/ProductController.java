package com.trendyol.axon.product.api.rest;

import com.trendyol.axon.product.api.command.CreateProductCommand;
import com.trendyol.axon.product.api.rest.request.CreateProductModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/products")
public class ProductController {
    private final CommandGateway commandGateway;
    @PostMapping
    public ResponseEntity<String> createProduct(@RequestBody @Valid CreateProductModel createProductModel) {

        final var createProductCommand = CreateProductCommand.builder()
                .title(createProductModel.getTitle())
                .price(createProductModel.getPrice())
                .quantity(createProductModel.getQuantity())
                .id(UUID.randomUUID().toString())
                .build();

        final String result = commandGateway.sendAndWait(createProductCommand);

        return ResponseEntity.ok(result);
    }

}
