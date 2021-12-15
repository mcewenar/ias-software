package com.iassoftware.products;

import com.iassoftware.products.domain.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductsApplication.class, args);

		//Product product = new Product("123","Bo",23,true);
	}

}
