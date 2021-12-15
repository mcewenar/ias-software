package com.iassoftware.products.controllers;

import com.iassoftware.products.domain.Product;
import com.iassoftware.products.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

//Spring boot decorators
@RestController
@RequestMapping(value="/products")
//Here, we will create the endpoints fot communicate us with the frontend using HTTP methods Hand in hand with Api-rest
public class ProductController {
    //Connect Repository with controller using repository attribute name.
    private ProductRepository repository;

    //Constructor
    public ProductController(ProductRepository repository) {
        this.repository = repository;
    }
    //Request HTTP using decorators
    @GetMapping
    //Diamond operators allow us bringing Products Object from clientside
    //Return a Products list
    public List<Product> productList() {
        return repository.list();
    }
    //Post decorator for create any product from Clientside
    @PostMapping
    public Product createPerson(@RequestBody Product product) {
        repository.create(product); //Bring this method from repository dependency
        return product;
    }
    //Get product by id
    @GetMapping(value="/{referenceId}")
    public Product getProduct(@PathVariable("referenceId") String referenceId) {

        return repository.findOne(referenceId);
    }
    //Delete by Idreference
    @DeleteMapping(value = "/{referenceId}")
    public Product deleteProduct(@PathVariable("referenceId") String productId) {
        //Verify that already product exist. If not find it, we should create a throw advise. (Not made yet)
        Product productFound = repository.findOne(productId);
        repository.delete(productId);
        return productFound;
    }
    //Update a product by Idreference
    @PutMapping(value = "/{referenceId}")
    //Post, Patch and Put need a body
    public Product updateProduct(@PathVariable("referenceId") String referenceId,
                                 @RequestBody Product product) {
        repository.update(referenceId, product);
        return repository.findOne(referenceId);
    }
}
