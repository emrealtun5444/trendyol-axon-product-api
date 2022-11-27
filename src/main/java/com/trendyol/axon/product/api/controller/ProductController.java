package com.trendyol.axon.product.api.controller;

import com.trendyol.axon.product.api.controller.request.CreateProductModel;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/products")
public class ProductController {

    @PostMapping
    public ResponseEntity<Boolean> createProduct(@RequestBody @Valid CreateProductModel createProductModel) {
        return ResponseEntity.ok(true);
    }

}
