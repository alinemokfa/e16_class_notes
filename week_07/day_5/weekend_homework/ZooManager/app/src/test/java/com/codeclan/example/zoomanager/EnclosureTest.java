package com.codeclan.example.zoomanager;

import com.codeclan.example.zoomanager.animal.Lion;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by JarrodBennie on 10/11/2017.
 */

public class EnclosureTest {
    Lion lion1;
    Lion lion2;
    Enclosure<Lion> enclosure;

    @Before
    public void before() {
        lion1 = new Lion(1000);
        lion2 = new Lion(1500);
        enclosure = new Enclosure<>();
    }

    @Test
    public void startsWithEmptyArrayOfAnimals() {
        int actual = enclosure.numberOfAnimals();
        assertEquals(0, actual);
    }

    @Test
    public void canAddAnimal() {
        enclosure.add(lion1);
        int actual = enclosure.numberOfAnimals();
        assertEquals(1, actual);
    }

    @Test
    public void canRemoveAnimal() {
        enclosure.add(lion1);
        enclosure.add(lion2);
        enclosure.remove(lion1);
        int actual = enclosure.numberOfAnimals();
        assertEquals(1, actual);
    }

    @Test
    public void canCalculateValueOfAnimals() {
        enclosure.add(lion1);
        enclosure.add(lion2);
        double actual = enclosure.valueOfAnimals();
        assertEquals(2500.0, actual, 0.01);
    }

    @Test
    public void enclosureContainsAnimal() {
        enclosure.add(lion1);
        boolean actual = enclosure.contains(lion1);
        assertEquals(true, actual);
    }

    @Test
    public void enclosureDoesNotContainAnimal() {
        boolean actual = enclosure.contains(lion1);
        assertEquals(false, actual);
    }
}
