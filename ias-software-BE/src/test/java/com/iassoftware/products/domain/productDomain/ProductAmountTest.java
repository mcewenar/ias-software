package com.iassoftware.products.domain.productDomain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.function.Executable;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Pruebas Unitarias:
 * 	Pirámide de pruebas: diferentes tipos de prueba.
 * 		Unit testing.
 *
 * 		Junit 5 para hacer pruebas:
 * 		Etiquetas especiales:
 *                        @Test
 *            @DisplayName("1 until 100 is a valid product"
 *
 * 			A(rrange): Opciones de prueba
 * 			A(ct): ACCIÓN QUE QUEREMOS ESPERAR
 * 			A(ssert): Lo que se espera que salga.
 * 			buscar IntToTest(value)
 **/

class ProductAmountTest {

    private DynamicTest IntToTest(int value) {
        String testName = "Value " + value + " should be valid";
        return DynamicTest.dynamicTest(testName, () -> {

            // act
            ProductAmount productAmount = new ProductAmount(value);

            // assert
            assertEquals(value, productAmount.asInteger());
        });
    }


    @TestFactory
    @DisplayName("1 until 100 is a valid product quantity")
    Stream<DynamicTest> validValues() {
        return IntStream.rangeClosed(1, 100)
                .mapToObj(value -> this.IntToTest(value));
    }


    @Test
    @DisplayName("Product quantity null throws an error")
    void nullCheck() {
        // arrange
        Integer value = null;

        // act
        Executable executable = () -> new ProductAmount(value);


        // assert
        assertThrows(NullPointerException.class, executable);
    }


    @Test
    @DisplayName("Invalid product quantity throws an error")
    void illegalValueCheck() {
        // arrange
        int value = -34;

        // act
        Executable executable = () -> new ProductAmount(value);


        // assert
        assertThrows(IllegalArgumentException.class, executable);
    }
}