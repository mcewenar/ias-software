package com.iassoftware.products.model.shoppingCartModel;


import com.iassoftware.products.domain.productDomain.Product;

import java.util.List;


public class CreateShoppingCartInput {
    private String userId;
    private List<Product> products;

    public CreateShoppingCartInput() {
    }

    public CreateShoppingCartInput(String userId, List<Product> products) {
        this.userId = userId;
        this.products = products;
    }

    public String getUserId() {
        return userId;
    }

    public List<Product> getProduct() {
        return products;
    }
}