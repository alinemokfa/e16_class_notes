package codeclan.com.tddintro;

/**
 * Created by user on 31/10/2017.
 */

public class Robot {
    private String name;
    private String colour;
    private double battery;

    public Robot(String name, String colour) {
        this.name = name;
        this.colour = colour;
        this.battery = 100.0;
    }

    public String getName() {
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

    public String doDusting() {
        this.battery -= 20.00;
        return "I am dusting";
    }

    public void rechargeBattery() {
        this.battery = 100.00;
    }
}






