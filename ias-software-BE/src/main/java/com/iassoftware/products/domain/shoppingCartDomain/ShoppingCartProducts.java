package com.iassoftware.products.domain.shoppingCartDomain;

import com.iassoftware.products.domain.productDomain.Product;
import com.iassoftware.products.domain.productDomain.ProductAmount;

import java.util.List;
import java.util.Objects;

public class ShoppingCartProducts {
    List<Product> product;

    public ShoppingCartProducts(List<Product> product) {
        Objects.requireNonNull(product, "product list can not be null");
        this.product = product;
    }
    public int ShoppingCartPrice(List<Product> product) {
        int totalCost = 0;
        //We could use map function
        for(Product eachProduct: product) {
            totalCost += eachProduct.getProductPrice().asInteger();
        }
        return totalCost;
    }
    /*public ShoppingCartClasification(List<Product> product, String Clasification) {
    }*/

    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "ShoppingCartProducts{" +
                "product=" + product +
                '}';
    }
}
