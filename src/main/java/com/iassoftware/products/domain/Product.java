package com.iassoftware.products.domain;

import java.time.Instant;
import java.util.Objects;

//id,nombre,descripcion,precio
public class Product {
    //Privates attribute that restrict access since other class or Package. Then, we create getters
    //and setters for accessing to this.

    //For each class we must create our own class that performs the particular business logic. More readable.
    //Unique responsibility SOLID
    private final ProductReference referenceId;
    private final ProductName productName;
    private final ProductPrice price;
    private final ProductDescription description;
    //private final Instant getProduct; //This is provided for an import from java.time

    //Product's constructor
    public Product(ProductReference referenceId, ProductName productName, ProductPrice amount, ProductDescription description) {
         /* requireNonNull: Checks that the specified object reference is not null and throws a customized NullPointerException
            if it is. This method is designed primarily for doing parameter validation
            in methods and constructors with multiple parameters, as demonstrated below:
         */
        Objects.requireNonNull(referenceId, "Product reference can not be null");
        Objects.requireNonNull(productName, "Product name can not be null");
        Objects.requireNonNull(amount, "Product amount can not be null");
        Objects.requireNonNull(description, "Product reference can not be null");
        //Objects.requireNonNull(getProduct, "Product name can not be null");
        this.referenceId = referenceId;
        this.productName = productName;
        this.price = amount;
        this.description = description;
        //this.getProduct = getProduct;
    }

    public ProductReference getReferenceId() {

        return referenceId;
    }

    public ProductName getProductName() {

        return productName;
    }

    public ProductPrice getPrice() {

        return price;
    }
    public ProductDescription getDescription() {

        return description;
    }

    //This is an override polymorphism that allow us parsing objects to String.
    @Override
    public String toString() {
        return super.toString();
    }
}
