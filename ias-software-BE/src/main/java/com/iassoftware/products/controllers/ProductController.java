package com.iassoftware.products.controllers;


import com.iassoftware.products.domain.productDomain.*;
import com.iassoftware.products.model.productModel.CreateProductInput;
import com.iassoftware.products.model.productModel.CreateProductOutput;
import com.iassoftware.products.model.productModel.UpdateProductInput;
import com.iassoftware.products.model.productModel.UpdateProductOutput;
import com.iassoftware.products.services.ProductServices;
import org.springframework.web.bind.annotation.*;
import java.util.List;

//Spring boot decorators
@RestController
@RequestMapping(value="/products")
//Here, we will create the endpoints fot communicate us with the frontend using HTTP methods Hand in hand with Api-rest
public class ProductController {
    //Connect Repository with controller using repository attribute name.
    private final ProductServices services;

    //Constructor
    public ProductController(ProductServices services) {
        this.services = services;
    }
    //Request HTTP using decorators
    @GetMapping
    //Diamond operators allow us bringing Products Object from clientside
    //Return a Products list
    public List<Product> listProducts() {
        return services.listProducts();
    }
    //Post decorator for create any product from Clientside
    @PostMapping
    public CreateProductOutput createProduct(@RequestBody CreateProductInput input) {
        ProductReference random = ProductReference.random();
        ProductName productName = new ProductName(input.getProductName());
        ProductPrice productPrice = new ProductPrice(input.getPrice());
        ProductAmount productAmount = new ProductAmount(input.getAmount());
        ProductDescription productDescription = new ProductDescription(input.getDescription());

        Product product = new Product(random, productName, productAmount, productPrice, productDescription);
        Product createdProduct = services.createProduct(product);

        return new CreateProductOutput(createdProduct);
    }
    //Get product by id
    @GetMapping(value="/{referenceId}")
    public Product getProduct(
            @PathVariable("referenceId") String referenceId) {
        final ProductReference id = ProductReference.fromString(referenceId);
        return services.getProduct(id);//???
    }
    //Delete by id reference
    @DeleteMapping(value = "/{referenceId}")
    public void deleteProduct(
            @PathVariable("referenceId") String productId) {
        //Verify that already product exist. If not find it, we should create a throw advise. (Not made yet)
        final ProductReference productFound = ProductReference.fromString(productId);
        services.deleteProduct(productFound);
    }
    //Update a product by id reference
    @PutMapping(value = "/{referenceId}") //Update receive body from client, likewise Post http
    //Post, Patch and Put need a body
    public UpdateProductOutput updateProduct(@PathVariable("referenceId") String unsafeId, @RequestBody UpdateProductInput input) {
        final ProductReference id = ProductReference.fromString(unsafeId);
        Product newProduct = new Product(id, new ProductName(input.getProductName()), new ProductAmount(input.getAmount()), new ProductPrice(input.getPrice()), new ProductDescription(input.getDescription()));
        final Product updated = services.updateProduct(id, newProduct);
        return new UpdateProductOutput(updated);
    }
}

