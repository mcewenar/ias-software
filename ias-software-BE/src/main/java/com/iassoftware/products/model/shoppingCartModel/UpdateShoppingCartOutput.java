package com.iassoftware.products.model.shoppingCartModel;

import com.iassoftware.products.domain.personDomain.Person;
import com.iassoftware.products.domain.shoppingCartDomain.ShoppingCart;

public class UpdateShoppingCartOutput {
    private ShoppingCart shoppingCart;

    public UpdateShoppingCartOutput() {
    }

    public UpdateShoppingCartOutput(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setPerson(Person person) {
        this.shoppingCart = shoppingCart;
    }
}
