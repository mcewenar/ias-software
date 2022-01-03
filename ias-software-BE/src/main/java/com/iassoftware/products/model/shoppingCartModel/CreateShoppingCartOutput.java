package com.iassoftware.products.model.shoppingCartModel;


import com.iassoftware.products.domain.productDomain.Product;
import com.iassoftware.products.domain.shoppingCartDomain.ShoppingCart;
import com.iassoftware.products.domain.shoppingCartDomain.ShoppingCartProducts;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CreateShoppingCartOutput {
    private ShoppingCart shoppingCart;
    private CreateShoppingCartInput input;
    private List<Product> products;



    public CreateShoppingCartOutput() {

    }

    public CreateShoppingCartOutput(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public void setHahsMap(HashMap<String,ShoppingCartProducts> shoppingCartProductsHashMap) {


    }
}