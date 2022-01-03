package com.iassoftware.products.model.shoppingCartModel;

import com.iassoftware.products.domain.productDomain.Product;

import java.util.List;

public class UpdateShoppingCartInput {
    private List<Product> products;
    private String idPerson;

    public UpdateShoppingCartInput() {
    }
    public UpdateShoppingCartInput(List<Product> products, String idPerson) {
        this.products = products;
        this.idPerson = idPerson;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public String getPerson() {
        return idPerson;
    }
}
