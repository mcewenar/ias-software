package com.iassoftware.products.domain;
import java.util.Objects;
import java.util.UUID; //Generate unique identifiers for IdReference. (Primary key made for Controller)

public class ProductReference {
    private final UUID value;

    public ProductReference(UUID value) {
        Objects.requireNonNull(value, "Person id can not be null");
        this.value = value;
    }

        public static ProductReference fromString(String unsafeValue) { //String to new object ProductReference
            return new ProductReference(UUID.fromString(unsafeValue));
        }

        public static ProductReference random() {

            return new ProductReference(UUID.randomUUID()); //Create a new ID "randomly"
        }

        @Override
        public String toString() {

            return value.toString();
        }
}