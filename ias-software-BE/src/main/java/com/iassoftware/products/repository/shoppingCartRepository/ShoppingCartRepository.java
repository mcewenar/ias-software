package com.iassoftware.products.repository.shoppingCartRepository;

import com.iassoftware.products.domain.shoppingCartDomain.ShoppingCart;
import com.iassoftware.products.domain.shoppingCartDomain.ShoppingCartId;

import java.util.List;

public interface ShoppingCartRepository {
    List<ShoppingCart> list();
    ShoppingCart findOne(ShoppingCartId shoppingCartId);
    void create (ShoppingCart shoppingCart);
    void update(ShoppingCartId shoppingCartId, ShoppingCart shoppingCart);
    void delete(ShoppingCartId shoppingCartId);

}
