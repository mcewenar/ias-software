package com.iassoftware.products.services;

import com.iassoftware.products.domain.personDomain.Person;
import com.iassoftware.products.domain.personDomain.PersonId;
import com.iassoftware.products.domain.productDomain.Product;
import com.iassoftware.products.domain.productDomain.ProductReference;
import com.iassoftware.products.domain.shoppingCartDomain.ShoppingCart;
import com.iassoftware.products.domain.shoppingCartDomain.ShoppingCartId;
import com.iassoftware.products.repository.productRepository.ProductRepository;
import com.iassoftware.products.repository.shoppingCartRepository.ShoppingCartRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCartServices {
    private final ShoppingCartRepository shoppingCartRepository;
    public ShoppingCartServices(ShoppingCartRepository shoppingCartRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
    }

    public List<ShoppingCart> listShoppingCart() {
        return shoppingCartRepository.list();
    }
    public ShoppingCart createShoppingCart(ShoppingCart shoppingCart) {
        shoppingCartRepository.create(shoppingCart);
        return shoppingCart;
    }
    public ShoppingCart getShoppingCart(ShoppingCartId shoppingCartId) {
        return shoppingCartRepository.findOne(shoppingCartId);
    }
    public void deleteShoppingCart(ShoppingCartId shoppingCartId) {
        shoppingCartRepository.delete(shoppingCartId);
    }


    public ShoppingCart updateShoppingCart(ShoppingCartId shoppingCartId, ShoppingCart shoppingCart) {
        shoppingCartRepository.update(shoppingCartId, shoppingCart);

        return shoppingCartRepository.findOne(shoppingCartId);
    }

}