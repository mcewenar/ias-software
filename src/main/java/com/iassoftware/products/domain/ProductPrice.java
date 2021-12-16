package com.iassoftware.products.domain;
import java.util.Objects;

public class ProductPrice {
    private final Integer value;
    public ProductPrice increment() {
        return new ProductPrice(value + 1);
    }

    public ProductPrice(Integer value) {
        Objects.requireNonNull(value, "Product price can not be null");
        if(value <= 0) {
            throw new IllegalArgumentException("Product price can not be less than 0");
        }
        this.value = value;
    }

    public Integer asInteger() {
        return value;
    }
}
