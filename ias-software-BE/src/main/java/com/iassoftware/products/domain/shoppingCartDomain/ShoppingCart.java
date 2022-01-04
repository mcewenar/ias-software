package com.iassoftware.products.domain.shoppingCartDomain;

import java.time.Instant;
import java.util.HashMap;
import java.util.Objects;
/**
 * identificador del cliente (UUID)
 *     - Fecha de creación
 *     - Fecha de ultima actualización
 *     - productos y cantidades
 *         - Identificador del producto
 *         - precio del producto: Money
 *         - Cantidad del producto
 *     - Total a pagar: Money (calculado)*
 **/
public class ShoppingCart {

    private final ShoppingCartId shoppingCartId;
    private final String clientId;
    private final ShoppingCartProducts shoppingCartProducts;
    private final Instant createdShoppingCart;
    private HashMap<String, ShoppingCartProducts> shoppingCartForPerson;


    public ShoppingCart(ShoppingCartId shoppingCartId,String clientId, ShoppingCartProducts shoppingCartProducts, Instant createdShoppingCart) {
        Objects.requireNonNull(clientId,"Client Id can not be null");
        Objects.requireNonNull(shoppingCartId, "Shopping Cart id can not be null");

        this.clientId = clientId;
        this.shoppingCartId = shoppingCartId;
        this.shoppingCartProducts = shoppingCartProducts;
        this.createdShoppingCart = createdShoppingCart;



    }
    public HashMap<String,ShoppingCartProducts> assignIdToShoppingCart(HashMap<String, ShoppingCartProducts> shoppingCartForPerson) {
        shoppingCartForPerson.put(clientId,shoppingCartProducts);

        return shoppingCartForPerson;

    }

    public ShoppingCartId getShoppingCartId() {
        return shoppingCartId;
    }

    public String getClientId() {
        return clientId;
    }

    public ShoppingCartProducts getShoppingCartProducts() {
        return shoppingCartProducts;
    }

    public Instant getCreatedShoppingCart() {
        return createdShoppingCart;
    }


    @Override
    public String toString() {
        return "ShoppingCart{" +
                "shoppingCartId=" + shoppingCartId +
                ", clientId='" + clientId + '\'' +
                ", shoppingCartProducts=" + shoppingCartProducts +
                ", createdShoppingCart=" + createdShoppingCart +
                '}';
    }
}
