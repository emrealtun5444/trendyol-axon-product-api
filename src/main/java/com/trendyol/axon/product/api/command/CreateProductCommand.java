package com.trendyol.axon.product.api.command;

import com.trendyol.axon.product.api.command.rest.CreateProductRequestModel;
import com.trendyol.axon.product.api.common.BaseCommand;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.UUID;

@SuperBuilder
@Getter
public class CreateProductCommand extends BaseCommand<String> {

    private final String barcode;
    private final String title;
    private final String brand;
    private final String category;
    private final String description;
    private final BigDecimal price;
    private final Integer quantity;

    public static CreateProductCommand create(CreateProductRequestModel createProductRequestModel) {
        return CreateProductCommand.builder()
                .barcode(createProductRequestModel.getBarcode())
                .title(createProductRequestModel.getTitle())
                .brand(createProductRequestModel.getBrand())
                .category(createProductRequestModel.getCategory())
                .description(createProductRequestModel.getDescription())
                .price(createProductRequestModel.getPrice())
                .quantity(createProductRequestModel.getQuantity())
                .id(UUID.randomUUID().toString())
                .build();
    }

}
