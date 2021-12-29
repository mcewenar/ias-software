package com.iassoftware.products.domain.shoppingCartDomain;

import java.util.Objects;
import java.util.UUID;

public class ShoppingCartId {
    private final UUID value;

    public ShoppingCartId(UUID value) {
        Objects.requireNonNull(value, "Shopping cart id can not be null");
        this.value = value;
    }

    public static ShoppingCartId fromString(String unsafeValue) {
        return new ShoppingCartId(UUID.fromString(unsafeValue));
    }

    public static ShoppingCartId random() {
        return new ShoppingCartId(UUID.randomUUID());
    }


    @Override
    public String toString() {
        return value.toString();
    }
}
