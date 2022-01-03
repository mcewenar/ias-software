package com.iassoftware.products.domain.productDomain;

import java.util.Objects;

public class Product {
    //Privates attribute that restrict access since other class or Package. Then, we create getters
    //and setters for accessing to this.

    //For each class we must create our own class that performs the particular business logic. More readable.
    //Unique responsibility SOLID
    private final ProductReference referenceId;
    private final ProductName productName;
    private final ProductAmount productAmount;
    private final ProductPrice productPrice;
    private final ProductDescription description;
    //private final Instant getProduct; //This is provided for an import from java.time

    //Product's constructor
    public Product(ProductReference referenceId, ProductName productName, ProductAmount productAmount, ProductPrice productPrice, ProductDescription description) {
         /* requireNonNull: Checks that the specified object reference is not null and throws a customized NullPointerException
            if it is. This method is designed primarily for doing parameter validation
            in methods and constructors with multiple parameters, as demonstrated below:
         */
        Objects.requireNonNull(referenceId, "Product reference can not be null");
        Objects.requireNonNull(productName, "Product name can not be null");
        Objects.requireNonNull(productPrice, "Product price can not be null");
        Objects.requireNonNull(description, "Product reference can not be null");
        Objects.requireNonNull(productAmount, "Product amount can not be null");
        //Objects.requireNonNull(getProduct, "Product name can not be null");
        this.referenceId = referenceId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.description = description;
        this.productAmount = productAmount;
    }

    public ProductReference getReferenceId() {

        return referenceId;
    }

    public ProductName getProductName() {

        return productName;
    }

    public ProductPrice getProductPrice() {

        return productPrice;
    }
    public ProductDescription getDescription() {

        return description;
    }

    public ProductAmount getProductAmount() {
        return productAmount;
    }

    //This is an override polymorphism that allow us parsing objects to String.
    @Override
    public String toString() {
        return super.toString();
    }
}
