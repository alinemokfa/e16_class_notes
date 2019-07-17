package com.codeclan.example.zoomanager;

import com.codeclan.example.zoomanager.animal.Animal;

import java.util.ArrayList;

/**
 * Created by JarrodBennie on 10/11/2017.
 */

public class Enclosure<T extends Animal> {
    ArrayList<T> animals;

    public Enclosure() {
        this.animals = new ArrayList<>();
    }

    public int numberOfAnimals() {
        return this.animals.size();
    }

    public void add(T animal) {
        this.animals.add(animal);
    }

    public void remove(T animal) {
        this.animals.remove(animal);
    }

    public double valueOfAnimals() {
        double total = 0;
        for (T animal : animals) {
            total += animal.getCashValue();
        }
        return total;
    }

    public boolean contains(T animal) {
        return this.animals.contains(animal);
    }
}
