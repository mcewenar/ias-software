package com.iassoftware.products.controllers;

import com.iassoftware.products.domain.personDomain.Person;
import com.iassoftware.products.domain.productDomain.*;
import com.iassoftware.products.domain.shoppingCartDomain.ShoppingCart;
import com.iassoftware.products.services.ShoppingCartServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(value="/shopping-cart")
public class ShoppingCartController {
    /*Adding to cart (POST)
    Getting the whole cart (GET)
    Update quantity in the cart (PUT)
    Delete item from the cart (DELETE)*/

//Here, we will create the endpoints fot communicate us with the frontend using HTTP methods Hand in hand with Api-rest

    //Connect Repository with controller using repository attribute name.
    private final ShoppingCartServices services;
    private final Person personId;

    //Constructor
    public ShoppingCartController(ShoppingCartServices services, Person personId) {
        this.personId = personId;
        this.services = services;
    }

    //Request HTTP using decorators
    @GetMapping
    //Diamond operators allow us bringing Products Object from clientside
    //Return a Products list
    public ShoppingCart showShoppingCart() {
        ShoppingCart cartProducts = services

        return cartProducts;
    }

}