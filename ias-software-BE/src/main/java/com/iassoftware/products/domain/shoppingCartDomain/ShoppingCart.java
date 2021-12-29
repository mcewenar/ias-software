package com.iassoftware.products.domain.shoppingCartDomain;

import com.iassoftware.products.domain.personDomain.Person;
import com.iassoftware.products.domain.personDomain.PersonId;
import com.iassoftware.products.domain.productDomain.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;


public class ShoppingCart {
    /* - identificador del cliente (UUID)
    - Fecha de creación
    - Fecha de ultima actualización
    - productos y cantidades
        - Identificador del producto
        - precio del producto: Money
        - Cantidad del producto
    - Total a pagar: Money (calculado)*/
    /*private final List<ProductList> productList;
    private final PersonId personId;
    private final ShoppingCarInitDate initDate;
    private final ShoppingCarLastUpdate LastUpdateDate;

    */
    private final ShoppingCartId shoppingCartId;
    private final Product product;
    private final List<Product> productList;
    private final Person personId;
    private final ProductAmount productAmount;
    private final LocalDate shoppingCartDateInit;

    public ShoppingCart(Product product,List<Product> productList, Person personId, ProductAmount productAmount, LocalDate shoppingCartDateInit, ShoppingCartId shoppingCartId) {
        Objects.requireNonNull(shoppingCartId, "Shopping Cart id can not be null");
        Objects.requireNonNull(product, "Product id can not be null");
        Objects.requireNonNull(personId, "Person id can not be null");
        Objects.requireNonNull(productAmount, "Product amount can not be null");
        Objects.requireNonNull(shoppingCartDateInit, "Date init can not be null");

        this.product = product;
        this.productList = productList;
        this.personId = personId;
        this.productAmount=productAmount;
        this.shoppingCartDateInit = shoppingCartDateInit;
        this.shoppingCartId = shoppingCartId;
    }

    public Product getProduct() {
        return product;
    }

    public Person getPerson() {return personId;}

    public ProductAmount getProductAmount() {

        return productAmount;
    }

    public LocalDate getShoppingCartDateInit() {

        return shoppingCartDateInit;
    }

    public ShoppingCartId getShoppingCartId() {
        return shoppingCartId;
    }
}
