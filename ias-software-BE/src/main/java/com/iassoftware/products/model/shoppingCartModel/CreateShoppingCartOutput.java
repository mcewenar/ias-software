package com.iassoftware.products.model.shoppingCartModel;

import com.iassoftware.products.domain.personDomain.Person;
import com.iassoftware.products.domain.personDomain.PersonId;
import com.iassoftware.products.domain.productDomain.Product;
import com.iassoftware.products.domain.shoppingCartDomain.ProductAmount;
import com.iassoftware.products.domain.shoppingCartDomain.ShoppingCartId;

public class CreateShoppingCartOutput {


    private  ShoppingCartId id;
    private PersonId personId;
    private ProductAmount amount;
    private Product product;

    public CreateShoppingCartOutput() {
    }


    public ShoppingCartId getId() {
        return id;
    }

    public Person getPersonId() {
        return personId;
    }

    public ProductAmount getAmount() {
        return amount;
    }

    public Product getProduct() {
        return product;
    }

    @Override
    public String toString() {
        return "CartDto{" +
                "id=" + id +
                ", personId=" + personId +
                ", quantity=" + amount +
                ", product=" + product +
                '}';
    }

}