package com.iassoftware.products.model.shoppingCartModel;

import com.iassoftware.products.domain.personDomain.Person;
import com.iassoftware.products.domain.personDomain.PersonId;
import com.iassoftware.products.domain.productDomain.Product;
import com.iassoftware.products.domain.shoppingCartDomain.ProductAmount;


public class CreateShoppingCartInput {
    private PersonId userId;
    private Product product;
    private ProductAmount amount;

    public CreateShoppingCartInput() {
    }

    public CreateShoppingCartInput(PersonId userId, Product product, ProductAmount amount) {
        this.userId = userId;
        this.product = product;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "CartDto{" +
                ", userId=" + userId +
                ", product=" + product +
                ", amount=" + amount +
                ",";
    }

    public PersonId getUserId() {
        return userId;
    }

    public Product getProduct() {
        return product;
    }

    public ProductAmount getAmount() {
        return amount;
    }
}
