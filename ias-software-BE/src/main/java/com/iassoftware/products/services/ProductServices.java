package com.iassoftware.products.services;


import com.iassoftware.products.domain.productDomain.Product;
import com.iassoftware.products.domain.productDomain.ProductReference;
import com.iassoftware.products.repository.productRepository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServices {


        private ProductRepository repository;

        public ProductServices(ProductRepository repository) {
            this.repository = repository;
        }


        public List<Product> listProducts() {
            return repository.list();
        }


        public Product createProduct(Product product) {
            repository.create(product);
            return product;
        }


        public Product getProduct(ProductReference productId) {
            return repository.findOne(productId);
        }


        public void deleteProduct(ProductReference productId) {
            repository.delete(productId);
        }


        public Product updateProduct(ProductReference productId, Product product) {
            repository.update(productId, product);

            return repository.findOne(productId);
        }

}

