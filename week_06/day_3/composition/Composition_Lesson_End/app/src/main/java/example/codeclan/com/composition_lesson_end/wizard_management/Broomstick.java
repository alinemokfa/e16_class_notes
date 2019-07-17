package example.codeclan.com.composition_lesson_end.wizard_management;

import example.codeclan.com.composition_lesson_end.behaviours.Flyable;

/**
 * Created by user on 28/08/2017.
 */

public class Broomstick extends CleaningImplement implements Flyable {

    int speed;

    public Broomstick(String brand, int speed){
        super(brand);
        this.speed = speed;
    }

    public int getSpeed(){
        return this.speed;
    }

    public String fly(){
        return "mounting broom, running, skipping, flying!";
    }
}
