package com.codeclan.example.zoomanager;

/**
 * Created by JarrodBennie on 10/11/2017.
 */

public class Visitor {
    private String name;
    private double money;

    public Visitor(String name, double money) {
        this.name = name;
        this.money = money;
    }

    public String getName() {
        return this.name;
    }


    public double getMoney() {
        return this.money;
    }

    public void pay(double amount) {
        if (this.money >= amount) {
            this.money -= amount;
        }
    }
}
