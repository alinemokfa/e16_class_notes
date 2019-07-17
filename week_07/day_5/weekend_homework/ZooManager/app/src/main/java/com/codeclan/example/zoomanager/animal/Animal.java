package com.codeclan.example.zoomanager.animal;

/**
 * Created by JarrodBennie on 10/11/2017.
 */

public abstract class Animal {
    double cashValue;

    public Animal(double cashValue) {
        this.cashValue = cashValue;
    }

    public double getCashValue() {
        return this.cashValue;
    }
}
