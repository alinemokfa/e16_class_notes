package com.codeclan.example.interfaces_startpoint;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by user on 24/10/2017.
 */

public class SalmonTest {
    Salmon salmon;

    @Before
    public void setUp() throws Exception {
        salmon = new Salmon();
    }

    @Test
    public void testSalmonCanSwim() throws Exception {
        assertEquals("I'm swimming!", salmon.swim());
    }
}
