package com.trendyol.axon.product.api.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
@RequiredArgsConstructor
public class BaseEvent<T> {

    public T id;

}
