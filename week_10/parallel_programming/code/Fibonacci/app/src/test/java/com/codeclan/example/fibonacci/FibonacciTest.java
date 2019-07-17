package com.codeclan.example.fibonacci;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by user on 17/07/2017.
 */

public class FibonacciTest {
    @Test
    public void testFibonacci() throws Exception {
        assertEquals(55, Fibonacci.solve(10));
    }

    @Test
    public void testLargeFibonacci() throws Exception {
        assertEquals(1134903170, Fibonacci.solve(45));
    }
}
