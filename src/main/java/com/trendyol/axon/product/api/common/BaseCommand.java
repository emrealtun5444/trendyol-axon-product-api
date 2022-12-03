package com.trendyol.axon.product.api.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Getter
@SuperBuilder
@RequiredArgsConstructor
public class BaseCommand<T>  {

    @TargetAggregateIdentifier
    public final T id;

}
