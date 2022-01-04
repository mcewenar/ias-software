package com.iassoftware.products.domain.shoppingCartDomain;

import com.iassoftware.products.domain.productDomain.ProductReference;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartIdTest {
    @Test
    @DisplayName("Product reference null throws an error")
    void nullCheck() {
        // arrange
        UUID value = null;

        // act
        Executable executable = () -> new ShoppingCartId(null);


        // assert
        assertThrows(NullPointerException.class, executable);
    }

}