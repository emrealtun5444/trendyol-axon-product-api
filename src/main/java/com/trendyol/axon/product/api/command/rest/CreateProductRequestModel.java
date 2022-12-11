package com.trendyol.axon.product.api.command.rest;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Data
public class CreateProductRequestModel {
    @NotBlank
    private String barcode;
    @NotBlank
    private String title;
    @NotBlank
    private String brand;
    @NotBlank
    private String category;
    private String description;
    private BigDecimal price;
    private Integer quantity;
}
