package com.iassoftware.products.domain;
import java.util.Objects;
import java.util.regex.Pattern;

public class ProductDescription {
    private static final Pattern pattern = Pattern.compile("^[a-zA-Z\\s:]{1,150}$");
    private final String value;
    public ProductDescription(String value) {
        Objects.requireNonNull(value, "Person name can not be null");
        String trimmedValue = value.trim();
        if(trimmedValue.length()  == 0) {
            throw new IllegalArgumentException("Description can not be empty");
        }

        boolean isValid = pattern.matcher(trimmedValue).matches();
        if(!isValid) {
            throw new IllegalArgumentException("Invalid description");
        }

        this.value = trimmedValue;
    }
}