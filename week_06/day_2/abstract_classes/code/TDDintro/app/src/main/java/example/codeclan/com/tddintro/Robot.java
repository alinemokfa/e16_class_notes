package example.codeclan.com.tddintro;

/**
 * Created by tonygoncalves on 31/10/2017.
 */

public class Robot {
    private String name;
    private String colour;
    private double battery;

    public Robot(String name, String colour){
        this.name = name;
        this.colour = colour;
        this.battery = 100.0;
    }

    public String getName(){
      return this.name;
    }

    public String getColour() {
        return this.colour;
    }


    public double checkBattery() {
        return this.battery;
    }

    public String makeDrink(String drink) {
        this.battery -= 10;
        return "I am making " + drink;
    }

    public String washDish(String dishes) {
        this.battery -= 30;
        return "I am washing dishes";
    }

    public String robotDusting() {
        this.battery -=20.00;
        return "I am dusting";
    }

    public void rechargeBattery() {
        this.battery = 100.0;
    }
}
