package com.codeclan.example.zoomanager;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by JarrodBennie on 10/11/2017.
 */

public class VisitorTest {
    Visitor visitor;

    @Before
    public void before() {
        visitor = new Visitor("Jane", 25);
    }

    @Test
    public void canGetName() {
        String actual = visitor.getName();
        assertEquals("Jane", actual);
    }

    @Test
    public void canGetMoney() {
        double actual = visitor.getMoney();
        assertEquals(25, actual, 0.01);
    }

    @Test
    public void canPay() {
        visitor.pay(10);
        double actual = visitor.getMoney();
        assertEquals(15, actual, 0.01);
    }

    @Test
    public void cannotPayWithInsufficientFunds() {
        visitor.pay(26);
        double actual = visitor.getMoney();
        assertEquals(25, actual, 0.01);
    }
}
