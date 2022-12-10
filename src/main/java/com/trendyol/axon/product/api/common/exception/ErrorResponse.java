package com.trendyol.axon.product.api.common.exception;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
public class ErrorResponse {

    @Builder.Default
    private long timestamp = System.currentTimeMillis();

    @Builder.Default
    private Set<String> messages = new HashSet<>();

    public void addMessage(String message) {
        messages.add(message);
    }
}
