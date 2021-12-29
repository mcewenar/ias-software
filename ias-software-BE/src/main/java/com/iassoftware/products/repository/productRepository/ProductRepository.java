package com.iassoftware.products.repository.productRepository;

import com.iassoftware.products.domain.productDomain.Product;
import com.iassoftware.products.domain.productDomain.ProductReference;

import java.util.List;

//Interface
//Isn't necessary to specify methods for Interfaces Java. This is like
public interface ProductRepository {

    List<Product> list();
    Product findOne(ProductReference referenceId);

    //Not return
    void create(Product product);
    void delete(ProductReference referenceId);
    void update(ProductReference referenceId, Product product);
}
