//Forma tradicional:

package com.iassoftware.products.repository;
import com.iassoftware.products.domain.Product;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
//@Component
public class PostgresProductRepository implements ProductRepository {
    private final DataSource dataSource; //invoke the default dataSource
    public PostgresProductRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    @Override
    public List<Product> list() {
        //List all rows from a postgres DB
        List<Product> result = new ArrayList<>();
        String sqlQuery = "SELECT * FROM products ";

        try (
                Connection connection = dataSource.getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sqlQuery);
        ) {
            while (resultSet.next()) {
                String referenceId = resultSet.getString("referenceId");
                String productName = resultSet.getString("productName");
                int amount = resultSet.getInt("amount");
                boolean existence = resultSet.getBoolean("existence");
                Product product = new Product(
                        referenceId,
                        productName,
                        amount,
                        existence
                );
                result.add(product);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return result;
    }
    //Find a Product by IdReferences
    @Override
    public Product findOne(String referenceId) {
        Product product = null;

        String sqlQuery = "SELECT * FROM products WHERE referenceId = ?";
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement ps = connection.prepareStatement(sqlQuery);
        ) {
            ps.setString(1, referenceId);
            ResultSet resultSet = ps.executeQuery();
            if(resultSet.next()) {
                String productId = resultSet.getString("referenceId");
                String productName = resultSet.getString("productName");
                int amountProduct  = resultSet.getInt("amount");
                boolean existenceProduct = resultSet.getBoolean("existence");
                product = new Product(productId, productName,amountProduct,existenceProduct); //Instance new producto object
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return product;
    }

    @Override
    public void create(Product product) {
        String sqlQuery = "INSERT INTO products(referenceId, productName, amount, existence) values(?, ?, ?, ?, ?)";
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement ps = connection.prepareStatement(sqlQuery);
        ) {
            ps.setString(1, product.getReferenceId());
            ps.setString(2, product.getProductName());
            ps.setInt(3, product.getAmount());
            ps.setBoolean(4, product.isExistence());
            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(String id, Product product) {
        String sqlQuery = "UPDATE products SET referenceId = ?, productName = ?, amount = ?, existence = ? WHERE referenceId = ?";
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement ps = connection.prepareStatement(sqlQuery);
        ) {
            ps.setString(1, product.getReferenceId());
            ps.setString(2, product.getProductName());
            ps.setInt(3,product.getAmount());
            ps.setBoolean(4,product.isExistence());
            ps.setString(5, id); //Id search
            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String id) {
        String sqlQuery = "DELETE FROM products WHERE referenceId = ?";
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement ps = connection.prepareStatement(sqlQuery);
        ) {
            ps.setString(1, id);
            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

