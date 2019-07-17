package com.codeclan.example.zoomanager;

import com.codeclan.example.zoomanager.animal.Animal;

import java.util.ArrayList;

/**
 * Created by JarrodBennie on 10/11/2017.
 */

public class Zoo {
    private String name;
    private double ticketPrice;
    private double money;
    private ArrayList<Enclosure> enclosures;
    private ArrayList<Visitor> visitors;

    public Zoo(String name, double ticketPrice) {
        this.name = name;
        this.ticketPrice = ticketPrice;
        this.money = 0;
        this.enclosures = new ArrayList<>();
        this.visitors = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public double getTicketPrice() {
        return this.ticketPrice;
    }

    public double getMoney() {
        return this.money;
    }

    public void add(Enclosure enclosure) {
        this.enclosures.add(enclosure);
    }

    public void add(Visitor visitor) {
        this.visitors.add(visitor);
    }

    public void remove(Enclosure enclosure) {
        this.enclosures.remove(enclosure);
    }

    public void remove(Visitor visitor) {
        this.visitors.remove(visitor);
    }

    public int numberOfEnclosures() {
        return this.enclosures.size();
    }

    public int numberOfAnimals() {
        int total = 0;
        for (Enclosure enclosure : this.enclosures) {
            total += enclosure.numberOfAnimals();
        }
        return total;
    }

    public int numberOfVisitors() {
        return this.visitors.size();
    }

    public void sell(Animal animal) {
        for (Enclosure enclosure : this.enclosures) {
            if (enclosure.contains(animal)) {
                this.money += animal.getCashValue();
                enclosure.remove(animal);
            }
        }
    }

    public void sellTicket(Visitor visitor) {
        if (visitor.getMoney() < this.ticketPrice) return;
        visitor.pay(this.ticketPrice);
        this.money += this.ticketPrice;
    }

    public double valueOfAnimals() {
        double total = 0;
        for (Enclosure enclosure : this.enclosures) {
            total += enclosure.valueOfAnimals();
        }
        return total;
    }
}
