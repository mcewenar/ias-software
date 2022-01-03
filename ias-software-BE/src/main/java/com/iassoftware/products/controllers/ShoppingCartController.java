package com.iassoftware.products.controllers;

import com.iassoftware.products.domain.shoppingCartDomain.ShoppingCart;
import com.iassoftware.products.domain.shoppingCartDomain.ShoppingCartId;
import com.iassoftware.products.domain.shoppingCartDomain.ShoppingCartProducts;
import com.iassoftware.products.model.shoppingCartModel.CreateShoppingCartInput;
import com.iassoftware.products.model.shoppingCartModel.CreateShoppingCartOutput;
import com.iassoftware.products.model.shoppingCartModel.UpdateShoppingCartInput;
import com.iassoftware.products.model.shoppingCartModel.UpdateShoppingCartOutput;
import com.iassoftware.products.services.ShoppingCartServices;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*Spring boot decorators
 Here, we will create the endpoints fot communicate us with
 the frontend using HTTP methods Hand in hand with Api-rest
 */
@RestController
@RequestMapping(value="shopping-cart")
public class ShoppingCartController {
    //Connect Repository with controller using repository attribute name.
    private final ShoppingCartServices services;

    //Constructor
    public ShoppingCartController(ShoppingCartServices services) {
        this.services = services;
    }
    //Request HTTP using decorators
    @GetMapping
    //Diamond operators allow us bringing Products Object from clientside
    //Return a Products list
    public List<ShoppingCart> listProducts() {
        return services.listShoppingCart();
    }
    //Post decorator for create any product from Clientside
    @PostMapping
    public CreateShoppingCartOutput createProduct(@RequestBody CreateShoppingCartInput input) {
        ShoppingCartId random = ShoppingCartId.random();
        String personId = input.getUserId();
        ShoppingCartProducts shoppingCartProducts = new ShoppingCartProducts(input.getProduct());
        Instant createDateShoppingCart = Instant.now();

        ShoppingCart shoppingCart = new ShoppingCart(random, personId, shoppingCartProducts, createDateShoppingCart);
        ShoppingCart createdShoppingCart = services.createShoppingCart(shoppingCart);
        return new CreateShoppingCartOutput(createdShoppingCart);
    }

    @GetMapping(value="/{userId}")
    public ShoppingCart getShoppingCart(@PathVariable("userId") String userId) {
        final ShoppingCartId id = ShoppingCartId.fromString(userId);
        return services.getShoppingCart(id);
    }

    @DeleteMapping(value = "/{referenceId}")
    public void deleteShoppingCart(
            @PathVariable("referenceId") String shoppingCartId) {
        //Verify that already product exist. If not find it, we should create a throw advise. (Not made yet)
        final ShoppingCartId ShoppingCartFound = ShoppingCartId.fromString(shoppingCartId);
        services.deleteShoppingCart(ShoppingCartFound);
    }
    @PutMapping(value = "/{referenceId}") //Update receive body from client, likewise Post http
    //Post, Patch and Put need a body
    public UpdateShoppingCartOutput updateShoppingCart(@PathVariable("referenceId") String unsafeId, @RequestBody UpdateShoppingCartInput input) {
        final ShoppingCartId id = ShoppingCartId.fromString(unsafeId);
        ShoppingCart newShoppingCart = new ShoppingCart(id, input.getPerson(), new ShoppingCartProducts(input.getProducts()), Instant.now());
        final ShoppingCart updated = services.updateShoppingCart(id, newShoppingCart);
        return new UpdateShoppingCartOutput(updated);
    }
}

