package com.iassoftware.products.model;

import com.iassoftware.products.domain.Product;

public class CreateProductOutput {
    private Product product;

    public CreateProductOutput() {
    }

    public CreateProductOutput(Product product) {
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    public void setPerson(Product person) {
        this.product = product;
    }
}
