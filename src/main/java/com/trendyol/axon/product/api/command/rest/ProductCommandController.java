package com.trendyol.axon.product.api.command.rest;

import com.trendyol.axon.product.api.command.CreateProductCommand;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/products")
public class ProductCommandController {
    private final CommandGateway commandGateway;
    @PostMapping
    public ResponseEntity<String> createProduct(@RequestBody @Valid CreateProductRequestModel createProductRequestModel) {

        final var createProductCommand = CreateProductCommand.create(createProductRequestModel);
        final var result = commandGateway.sendAndWait(createProductCommand);

        return ResponseEntity.ok((String) result);
    }

}
