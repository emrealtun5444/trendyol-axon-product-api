package com.trendyol.axon.product.api.controller.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CreateProductModel {

    private String title;
    private BigDecimal price;
    private Integer quantity;

}
