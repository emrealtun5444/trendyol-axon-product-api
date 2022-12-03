package com.trendyol.axon.product.api.command;

import com.trendyol.axon.product.api.common.BaseCommand;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@SuperBuilder
@Getter
public class CreateProductCommand extends BaseCommand<String> {

    private final String title;
    private final BigDecimal price;
    private final Integer quantity;

}
