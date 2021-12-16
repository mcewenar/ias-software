package com.iassoftware.products.model;

import com.iassoftware.products.domain.Product;

public class UpdateProductOutput {
    private Product product;
//Polymorphism overloading (?)
    public UpdateProductOutput() {
    }

    public UpdateProductOutput(Product product) {
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    public void setPerson(Product product) {
        this.product = product;
    }
}
