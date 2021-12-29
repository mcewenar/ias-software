package com.iassoftware.products.domain.shoppingCartDomain;

import com.iassoftware.products.model.shoppingCartModel.CreateShoppingCartOutput;

import java.util.List;

public class ShoppingCartCost {
    private List<CreateShoppingCartOutput> cartItems;
    private int totalCost;

    public ShoppingCartCost(List<CreateShoppingCartOutput> createShoppingCartOutputList, int totalCost) {
        this.cartItems = createShoppingCartOutputList;
        this.totalCost = totalCost;
    }

    public List<CreateShoppingCartOutput> getcartItems() {
        return cartItems;
    }

    public void setCartItems(List<CreateShoppingCartOutput> createShoppingCartOutputList) {
        this.cartItems = createShoppingCartOutputList;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }
}

