package com.iassoftware.products.domain.productDomain;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.function.Executable;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ProductReferenceTest {

    @Test
    @DisplayName("Product reference null throws an error")
    void nullCheck() {
        // arrange
        UUID value = null;

        // act
        Executable executable = () -> new ProductReference(null);


        // assert
        assertThrows(NullPointerException.class, executable);
    }
}