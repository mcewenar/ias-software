package com.iassoftware.products.domain.productDomain;

import java.util.Objects;
import java.util.regex.Pattern;

public class ProductName {
    private static final Pattern pattern = Pattern.compile("^[a-zA-Z\\s:]{10,64}$"); //Lowercase: a-z, Uppercase: A-Z and letters length 10 to 64.
    private final String value;
    public ProductName(String value) {
        //Objects.requireNonNull(value, "Product name can not be null");
        String trimmedValue = value.trim();
        if(trimmedValue.length()  == 0) {
            throw new IllegalArgumentException("Product name can not be empty");
        }

        boolean isValid = pattern.matcher(trimmedValue).matches();
        if(!isValid) {
            throw new IllegalArgumentException("Invalid product name1");
        }

        this.value = trimmedValue; //trimmedValue assigned to value.
    }

    @Override
    public String toString() {
        return value;
    }
}
