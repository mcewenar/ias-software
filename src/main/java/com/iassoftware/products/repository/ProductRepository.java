package com.iassoftware.products.repository;
import com.iassoftware.products.domain.Product;

import java.util.List;

//Interface
//Isn't necessary to specify methods for Interfaces Java. This is like
public interface ProductRepository {



    List<Product> list();
    Product findOne(String referenceId);

    //Not return
    void create(Product product);
    void delete(String referenceId);
    void update(String referenceId, Product product);
}
