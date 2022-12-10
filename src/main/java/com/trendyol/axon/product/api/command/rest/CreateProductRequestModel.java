package com.trendyol.axon.product.api.command.rest;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CreateProductRequestModel {

    private String title;
    private String brand;
    private String category;
    private String description;
    private BigDecimal price;
    private Integer quantity;

}
