package com.codeclan.example.interfaces_startpoint;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by user on 24/10/2017.
 */

public class BearTest {
    Bear bear;
    Salmon salmon;

    @Before
    public void setUp() throws Exception {
        bear = new Bear("Baloo");
        salmon = new Salmon();
    }

    @Test
    public void testGetName() throws Exception {
        assertEquals("Baloo", bear.getName());
    }

    @Test
    public void testFoodCount() throws Exception {
        assertEquals(0, bear.foodCount());
    }

    @Test
    public void testCanEatSalmon() throws Exception {
        bear.eat(salmon);
        assertEquals(1, bear.foodCount());
    }

    @Test
    public void testEmptyBellyAfterSleeping() throws Exception {
        bear.eat(salmon);
        bear.sleep();
        assertEquals(0, bear.foodCount());
    }
}
