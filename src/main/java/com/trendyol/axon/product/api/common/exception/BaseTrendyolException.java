package com.trendyol.axon.product.api.common.exception;


public class BaseTrendyolException extends RuntimeException {
    private final String key;

    public BaseTrendyolException(String key) {
        this.key = key;
    }

    public String getKey() {
        return this.key;
    }

    @Override
    public String getMessage() {
        return "Exception occurred " + key;
    }

}
