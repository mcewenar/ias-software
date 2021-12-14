package com.iassoftware.products.repository;

import com.iassoftware.products.domain.Product;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.*;

public class InMemoryPersonsRepository {
    //These in memory repositories can then be injected into, for example, a service that you want to test
//The base class InMemoryJpaRepository makes it easy to create in-memory versions of Spring Data JPA repositories.
// The reason to use such repositories when testing is that they can be created and destroyed very quickly.
    @Component
    public class InMemoryProductsRepository implements ProductRepository {
        private final Map<String, Product> database = new HashMap<>(); //Is like Javascript object or Python Dictionary

        @Override
        public List<Product> list() {
            Collection<Product> values = database.values();
            return new ArrayList<>(values);
        }

        @Override
        public Product findOne(String referenceId) {
            return database.get(referenceId);
        }

        @Override
        public void create(Product product) {
            Product foundProduct = database.get(product.getReferenceId());
            if (foundProduct != null) {
                throw new IllegalArgumentException("Person with id: " + product.getReferenceId() + " already exists.");
            }
            database.put(product.getReferenceId(), product);
        }

        @Override
        public void update(String ReferenceId, Product product) {
            Product foundProduct = database.get(ReferenceId);
            if (foundProduct == null) {
                throw new IllegalArgumentException("Person with id: " + ReferenceId  + " not found");
            }

            database.put(ReferenceId, product);
        }

        @Override
        public void delete(String ReferenceId) {
            Product foundProduct = database.get(ReferenceId);
            if (foundProduct == null) {
                throw new IllegalArgumentException("Person with id: " + ReferenceId + " not found");
            }

            database.remove(ReferenceId);

        }
    }

}
