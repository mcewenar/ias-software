package com.iassoftware.products.repository.productRepository;


import com.iassoftware.products.domain.productDomain.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;
//JDBC with Spring Boot. More easy
@Component
public class SpringJdbcProductRepository implements ProductRepository {
    private final JdbcTemplate jdbcTemplate;
    public SpringJdbcProductRepository(JdbcTemplate jdbcTemplate) {

        this.jdbcTemplate = jdbcTemplate;
    }
    private final RowMapper<Product> rowMapper = (resultSet, rowNum) -> { //Lambda function. Like Lambda Py or Arrow
        // function in JS
        ProductReference productId = ProductReference.fromString(
                resultSet.getString("reference_id")
        );
        ProductName productName = new ProductName(resultSet.getString("product_name"));
        ProductPrice productPrice = new ProductPrice(resultSet.getInt("price"));
        ProductDescription productDescription = new ProductDescription(resultSet.getString("description"));
        return new Product(
                productId,
                productName,
                productPrice,
                productDescription
        );
    };


    @Override
    public List<Product> list() {
        String sqlQuery = "SELECT * FROM products ";
        return jdbcTemplate.query(sqlQuery, rowMapper);
    }

    @Override
    public Product findOne(ProductReference id) {
        String sqlQuery = "SELECT * FROM products WHERE reference_id = ?";
        return jdbcTemplate.queryForObject(sqlQuery, rowMapper, id.toString());
    }

    @Override
    public void create(Product product) {
        String sqlQuery = "INSERT INTO products(reference_id, product_name, price, description) values(?, ?, ?, ?)";
        jdbcTemplate.update(sqlQuery, ps -> {
            ps.setString(1, product.getReferenceId().toString());
            ps.setString(2, product.getProductName().toString());
            ps.setInt(3,product.getPrice().asInteger());
            ps.setString(4,product.getDescription().toString());
        });

    }

    @Override
    public void delete(ProductReference referenceId) {
        String sqlQuery = "DELETE FROM products WHERE reference_id = ?";
        jdbcTemplate.update(sqlQuery, referenceId.toString());
    }
    @Override
    public void update(ProductReference referenceId, Product product) {
        String sqlQuery = "UPDATE products SET product_name = ?, price = ?, description = ? WHERE reference_id = ?";
        jdbcTemplate.update(sqlQuery, ps -> {
            ps.setString(1, product.getProductName().toString());
            ps.setInt(2, product.getPrice().asInteger());
            ps.setString(3,product.getDescription().toString());
            ps.setString(4, referenceId.toString());
        });
    }
}
