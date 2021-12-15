package com.iassoftware.products.repository;

import com.iassoftware.products.domain.Product;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import java.sql.PreparedStatement;
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
        String productId = resultSet.getString("referenceId");
        String productName = resultSet.getString("productName");
        int productAmount = resultSet.getInt("amount");
        boolean productExistence = resultSet.getBoolean("existence");
        return new Product(
                productId,
                productName,
                productAmount,
                productExistence
        );
    };



    @Override
    public List<Product> list() {
        String sqlQuery = "SELECT * FROM products ";
        return jdbcTemplate.query(sqlQuery, rowMapper);
    }

    @Override
    public Product findOne(String referenceId) {
        String sqlQuery = "select * from persons where id_number = ?";
        return jdbcTemplate.queryForObject(sqlQuery, rowMapper, referenceId);
    }

    @Override
    public void create(Product product) {
        String sqlQuery = "INSERT INTO products(referenceId, productName, amount, existence) values(?, ?, ?, ?, ?)";
        jdbcTemplate.update(sqlQuery, ps -> {
            ps.setString(1, product.getReferenceId());
            ps.setString(2, product.getProductName());
            ps.setInt(3,product.getAmount());
            ps.setBoolean(4,product.isExistence());
        });

    }

    @Override
    public void delete(String referenceId) {
        String sqlQuery = "DELETE FROM products WHERE referenceId = ?";
        jdbcTemplate.update(sqlQuery, referenceId);
    }
    @Override
    public void update(String referenceId, Product product) {
        String sqlQuery = "UPDATE products SET referenceId = ?, productName = ?, amount = ?, existence = ? WHERE referenceId = ?";
        jdbcTemplate.update(sqlQuery, ps -> {
            ps.setString(1, product.getReferenceId());
            ps.setString(2, product.getReferenceId());
            ps.setInt(3, product.getAmount());
            ps.setBoolean(4,product.isExistence());
            ps.setString(3, referenceId);
        });

    }
}
