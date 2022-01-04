package com.iassoftware.products.domain.productDomain;
import java.util.Objects;

public class ProductPrice {

    private final int value;

    public ProductPrice(int value) {
        Objects.requireNonNull(value, "Product price can not be null");
        if(value <= 0 || value > 100) {
            throw new IllegalArgumentException("Product price can not be less than 0");
        }
        this.value = value;
    }

    public int getPrice() {
        return value;
    }

    public int asInteger() {
        return value;
    }
}