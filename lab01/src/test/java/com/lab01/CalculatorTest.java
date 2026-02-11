package com.lab01;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    @Test
    void testAddTwoPositiveNumbers() {
        Calculator calculator = new Calculator();
        int result = calculator.add(3, 4);
        assertEquals(7, result);
    }

    @Test
    void testAddPositiveAndNegativeNumbers() {
        Calculator calculator = new Calculator();
        int result = calculator.add(3, -4);
        assertEquals(-1, result);
    }

    @Test
    void testMultiplyTwoPositiveNumbers() {
        Calculator calculator = new Calculator();
        int result = calculator.multiply(3, 4);
        assertEquals(12, result);
    }

}
