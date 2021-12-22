package com.iassoftware.products.model.productModel;

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

    public void setProduct(Product product) {
        this.product = product;
    }
}
