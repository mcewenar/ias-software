package com.iassoftware.products.repository.shoppingCartRepository;

import com.iassoftware.products.domain.productDomain.Product;
import com.iassoftware.products.domain.shoppingCartDomain.ShoppingCart;
import com.iassoftware.products.domain.shoppingCartDomain.ShoppingCartId;
import com.iassoftware.products.domain.shoppingCartDomain.ShoppingCartProducts;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.Instant;
import java.util.HashMap;
import java.util.List;

@Component
public class SpringJdbcShoppingCartRepository implements ShoppingCartRepository {

    private final JdbcTemplate jdbcTemplate;

    public SpringJdbcShoppingCartRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<ShoppingCart> rowMapper = (resultSet, rowNum) -> {
        ShoppingCartId shoppingCartId = ShoppingCartId.fromString(
                resultSet.getString("shopping_cart_id")
        );
        String personId = resultSet.getString("person_id").toString();
        ShoppingCartProducts shoppingCartProducts = new ShoppingCartProducts(resultSet.getObject("products", new ParameterizedTypeReference<List<Product>>)); //?
        Instant createDate = resultSet.getDate("create_date").toInstant();
        HashMap<String, Product> ShoppingCartByIdClient = assignIdToShoppingCart();

        return new ShoppingCart(
                shoppingCartId,
                personId,
                shoppingCartProducts,
                createDate
        );
    };

    @Override
    public List<ShoppingCart> list() {
        String sqlQuery = "SELECT * FROM shopping_cart ";
        return jdbcTemplate.query(sqlQuery, rowMapper);
    }
    /*
    public HashMap<String,Product> getShoppingCartByIdUser(){
        String sqlQuery = "SELECT * shopping_cart WHERE id_user ";
        return jdbcTemplate.queryForObject(sqlQuery, HashMap<String,ShoppingCartProducts> );
    }*/

    @Override
    public ShoppingCart findOne(ShoppingCartId id) {
        String sqlQuery = "SELECT * FROM shopping_cart WHERE shopping_cart_id = ?";

        return jdbcTemplate.queryForObject(sqlQuery, rowMapper, id.toString());
    }

    @Override
    public void create(ShoppingCart shoppingCart) {
        String sqlQuery = "INSERT INTO shopping_cart(shopping_cart_id, person_id, products, create_date) values(?, ? ,? ,?)";
        jdbcTemplate.update(sqlQuery, ps -> {
            ps.setString(1, shoppingCart.getShoppingCartId().toString());
            ps.setString(2, shoppingCart.getClientId());
            ps.setString(3, shoppingCart.getShoppingCartProducts().toString());
            ps.setDate(4, Date.valueOf(shoppingCart.getCreatedShoppingCart().toString()));
        });
    }

    @Override
    public void update(ShoppingCartId id, ShoppingCart shoppingCart) {
        String sqlQuery = "UPDATE shopping_cart SET products = ? WHERE shopping_cart_id = ?";
        jdbcTemplate.update(sqlQuery, ps -> {
            ps.setObject(1, shoppingCart.getShoppingCartProducts());
            ps.setString(2, id.toString());
        });
    }
    @Override
    public void delete(ShoppingCartId shoppingCartId) {
        String sqlQuery = "DELETE FROM shopping_cart WHERE shopping_cart_id = ?";
        jdbcTemplate.update(sqlQuery, shoppingCartId.toString());
    }

}
