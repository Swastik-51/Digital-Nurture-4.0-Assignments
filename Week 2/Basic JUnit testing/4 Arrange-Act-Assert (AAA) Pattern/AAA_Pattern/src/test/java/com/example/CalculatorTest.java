package com.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {

    private Calculator calc;

    // ✅ Setup method
    @Before
    public void setUp() {
        System.out.println("Setting up Calculator...");
        calc = new Calculator();
    }

    // ✅ Teardown method
    @After
    public void tearDown() {
        System.out.println("Cleaning up Calculator...\n");
        calc = null;
    }

    @Test
    public void testAdd() {
        // Arrange
        int a = 10, b = 5;

        // Act
        int result = calc.add(a, b);

        // Assert
        assertEquals(15, result);
    }

    @Test
    public void testDivide() {
        // Arrange
        int a = 20, b = 4;

        // Act
        int result = calc.divide(a, b);

        // Assert
        assertEquals(5, result);
    }

    @Test(expected = ArithmeticException.class)
    public void testDivideByZero() {
        // Arrange + Act
        calc.divide(10, 0); // Should throw exception

        // Assert is handled by @Test(expected)
    }
}
