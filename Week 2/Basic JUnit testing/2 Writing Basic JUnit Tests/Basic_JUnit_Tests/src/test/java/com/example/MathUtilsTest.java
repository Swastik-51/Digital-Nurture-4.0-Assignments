package com.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class MathUtilsTest {

    @Test
    public void testSquare() {
        MathUtils mu = new MathUtils();
        int result = mu.square(5);
        assertEquals(25, result);
    }

    @Test
    public void testIsEven() {
        MathUtils mu = new MathUtils();
        assertTrue(mu.isEven(4));
        assertFalse(mu.isEven(7));
    }

    @Test
    public void testMax() {
        MathUtils mu = new MathUtils();
        assertEquals(10, mu.max(10, 7));
        assertEquals(20, mu.max(15, 20));
    }
}
