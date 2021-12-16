package com.iassoftware.products.controllers;

import com.iassoftware.products.domain.*;
import com.iassoftware.products.model.CreateProductInput;
import com.iassoftware.products.model.CreateProductOutput;
import com.iassoftware.products.model.UpdateProductInput;
import com.iassoftware.products.model.UpdateProductOutput;
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
    public CreateProductOutput createProduct(@RequestBody CreateProductInput input) {
        //Enter body HTTP requests from client (CreateInput), return body HTTP from Domain (CreateOutput)
        Product product = new Product(
                ProductReference.random(), //Generate into backend
                new ProductName(input.getProductName()), //get it From client side
                new ProductPrice(input.getPrice()), //get it From client side
                new ProductDescription(input.getDescription()) //get it From client side
        );
        repository.create(product);
        return new CreateProductOutput(product);
        //Bring this method from repository dependency
    }
    //Get product by id
    @GetMapping(value="/{referenceId}")
    public Product getProduct(
            @PathVariable("referenceId") String referenceId) {
        final ProductReference id = ProductReference.fromString(referenceId);
        return repository.findOne(id); //???
    }
    //Delete by Idreference
    @DeleteMapping(value = "/{referenceId}")
    public void deleteProduct(
            @PathVariable("referenceId") String productId) {
        //Verify that already product exist. If not find it, we should create a throw advise. (Not made yet)
        final ProductReference productFound = ProductReference.fromString(productId);
        repository.delete(productFound);
    }
    //Update a product by Idreference
    @PutMapping(value = "/{referenceId}") //Update receive body from client, likewise Post http
    //Post, Patch and Put need a body
    public UpdateProductOutput updateProduct(
            @PathVariable("referenceId") String unsafeId,
            @RequestBody UpdateProductInput input) {
        final ProductReference id = ProductReference.fromString(unsafeId);
        Product newProduct = new Product(
                id,
                new ProductName(input.getProductName()),
                new ProductPrice(input.getPrice()),
                new ProductDescription(input.getDescription())
        );
        repository.update(id, newProduct);
        final Product found = repository.findOne(id);
        return new UpdateProductOutput(found);
    }
}
