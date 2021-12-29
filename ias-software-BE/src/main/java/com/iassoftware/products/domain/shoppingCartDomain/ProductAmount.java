package com.iassoftware.products.domain.shoppingCartDomain;

import com.iassoftware.products.domain.productDomain.ProductPrice;

import java.util.Objects;

public class ProductAmount {
    private final int value;


    public ProductAmount(int value) {
        Objects.requireNonNull(value, "Product price can not be null");
        if(value <= 0) {
            throw new IllegalArgumentException("Product price can not be less than 0");
        }
        this.value = value;
    }

    public int asInteger() {
        return value;
    }

    public ProductAmount increment() {

        return new ProductAmount(value + 1);
    }
}
