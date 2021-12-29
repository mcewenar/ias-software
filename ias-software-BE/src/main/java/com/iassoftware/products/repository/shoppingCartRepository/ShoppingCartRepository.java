package com.iassoftware.products.repository.shoppingCartRepository;

import com.iassoftware.products.domain.personDomain.Person;
import com.iassoftware.products.domain.productDomain.Product;
import com.iassoftware.products.domain.shoppingCartDomain.ShoppingCart;

import java.util.List;

public interface ShoppingCartRepository {
    List<ShoppingCart> findByPerson(Person userId);
    List<Product> list();
    void create(Product product);
    void addToCart(Product product);

}
