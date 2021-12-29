package com.iassoftware.products.repository.shoppingCartRepository;

import com.iassoftware.products.configuration.ProductJacksonCodecs.ProductNameParser;
import com.iassoftware.products.domain.personDomain.Person;
import com.iassoftware.products.domain.personDomain.PersonId;
import com.iassoftware.products.domain.productDomain.*;
import com.iassoftware.products.domain.shoppingCartDomain.ProductAmount;
import com.iassoftware.products.domain.shoppingCartDomain.ShoppingCart;
import com.iassoftware.products.domain.shoppingCartDomain.ShoppingCartId;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Component
public class SpringJdbcShoppingCartRepository implements ShoppingCartRepository {
    private final JdbcTemplate jdbcTemplate;

    public SpringJdbcShoppingCartRepository(JdbcTemplate jdbcTemplate) {

        this.jdbcTemplate = jdbcTemplate;
    }
    private final RowMapper<ShoppingCart> rowMapper = (resultSet, rowNum) -> { //Lambda function. Like Lambda Py or Arrow
        // function in JS
        ShoppingCartId shoppingCartId = ShoppingCartId.fromString(
                resultSet.getString("shopping_cart_id")
        );
        ProductAmount productAmount = new ProductAmount(resultSet.getInt("shopping_cart_amount"));
        Person personId = Person.fromString(resultSet.getString())
        LocalDate shoppingCartDateInit = resultSet.getDate("shopping_cart_date-init").toLocalDate();
        return new ShoppingCart(
                personId,
                productAmount,
                shoppingCartDateInit,
                shoppingCartId
        );


    }
    @Override
    public ShoppingCart findByPerson(Person person) {
        String sqlQuery = "SELECT * FROM products WHERE reference_id = ?";
        return jdbcTemplate.queryForObject(sqlQuery, rowMapper, id.toString());
    }
}