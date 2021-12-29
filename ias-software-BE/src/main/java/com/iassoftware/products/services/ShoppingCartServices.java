package com.iassoftware.products.services;

import com.iassoftware.products.domain.personDomain.Person;
import com.iassoftware.products.domain.productDomain.Product;
import com.iassoftware.products.domain.shoppingCartDomain.ShoppingCart;
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

    public List<Product> listProducts() {
        return shoppingCartRepository.list();
    }
}