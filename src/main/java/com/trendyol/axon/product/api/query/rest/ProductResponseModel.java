package com.trendyol.axon.product.api.query.rest;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductResponseModel {

    private String id;
    private String title;
    private String brand;
    private String category;
    private String description;
    private BigDecimal price;
    private Integer quantity;

}
