package com.codeclan.example.zoomanager;

import com.codeclan.example.zoomanager.animal.Lion;
import com.codeclan.example.zoomanager.animal.Penguin;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by JarrodBennie on 10/11/2017.
 */

public class ZooTest {
    Lion lion1;
    Lion lion2;
    Penguin penguin;
    Enclosure<Lion> enclosure1;
    Enclosure<Penguin> enclosure2;
    Visitor visitor1;
    Visitor visitor2;
    Zoo zoo;

    @Before
    public void before() {
        lion1 = new Lion(1000);
        lion2 = new Lion(1500);
        penguin = new Penguin(250);
        enclosure1 = new Enclosure<>();
        enclosure2 = new Enclosure<>();
        visitor1 = new Visitor("Jane", 25);
        visitor2 = new Visitor("Mike", 9);
        zoo = new Zoo("CodeClan Zoo", 10);
    }

    @Test
    public void canGetName() {
        String actual = zoo.getName();
        assertEquals("CodeClan Zoo", actual);
    }

    @Test
    public void canGetTicketPrice() {
        double actual = zoo.getTicketPrice();
        assertEquals(10, actual, 0.01);
    }

    @Test
    public void canGetMoney() {
        double actual = zoo.getMoney();
        assertEquals(0, actual, 0.01);
    }

    @Test
    public void startsWithEmptyArrayOfEnclosures() {
        int actual = zoo.numberOfEnclosures();
        assertEquals(0, actual);
    }

    @Test
    public void startsWithEmptyArrayOfVisitors() {
        int actual = zoo.numberOfVisitors();
        assertEquals(0, actual);
    }

    @Test
    public void canAddEnclosure() {
        zoo.add(enclosure1);
        int actual = zoo.numberOfEnclosures();
        assertEquals(1, actual);
    }

    @Test
    public void canRemoveEnclosure() {
        zoo.add(enclosure1);
        zoo.add(enclosure2);
        zoo.remove(enclosure1);
        int actual = zoo.numberOfEnclosures();
        assertEquals(1, actual);
    }

    @Test
    public void canAddVisitor() {
        zoo.add(visitor1);
        int actual = zoo.numberOfVisitors();
        assertEquals(1, actual);
    }

    @Test
    public void canRemoveVisitor() {
        zoo.add(visitor1);
        zoo.add(visitor2);
        zoo.remove(visitor1);
        int actual = zoo.numberOfVisitors();
        assertEquals(1, actual);
    }

    @Test
    public void moneyShouldIncreaseWhenSellingTicket() {
        zoo.sellTicket(visitor1);
        double actual = zoo.getMoney();
        assertEquals(10, actual, 0.01);
    }

    @Test
    public void cannotSellTicketToCustomerWithInsufficientFunds() {
        zoo.sellTicket(visitor2);
        double actual = zoo.getMoney();
        assertEquals(0, actual, 0.01);
    }

    @Test
    public void canCalculateNumberOfAnimals() {
        enclosure1.add(lion1);
        enclosure1.add(lion2);
        enclosure2.add(penguin);
        zoo.add(enclosure1);
        zoo.add(enclosure2);
        int actual = zoo.numberOfAnimals();
        assertEquals(3, actual);
    }

    @Test
    public void animalIsRemovedAfterSelling() {
        enclosure1.add(lion1);
        enclosure1.add(lion2);
        enclosure2.add(penguin);
        zoo.add(enclosure1);
        zoo.add(enclosure2);
        zoo.sell(lion1);
        boolean actual = enclosure1.contains(lion1);
        assertEquals(false, actual);
    }

    @Test
    public void cashIsIncreasedAfterSellingAnimal() {
        enclosure1.add(lion1);
        enclosure1.add(lion2);
        enclosure2.add(penguin);
        zoo.add(enclosure1);
        zoo.add(enclosure2);
        zoo.sell(lion1);
        double actual = zoo.getMoney();
        assertEquals(1000, actual, 0.01);
    }

    @Test
    public void canCalculateValueOfAnimals() {
        enclosure1.add(lion1);
        enclosure1.add(lion2);
        enclosure2.add(penguin);
        zoo.add(enclosure1);
        zoo.add(enclosure2);
        double actual = zoo.valueOfAnimals();
        assertEquals(2750, actual, 0.01);
    }
}
