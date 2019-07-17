package example.codeclan.com.composition_lab_solution.wizard_management;


import example.codeclan.com.composition_lab_solution.behaviours.*;


/**
 * Created by user on 28/08/2017.
 */

public class Wizard {
    String name;
    Flyable ride;
    Protector guard;

    public Wizard(String name, Flyable ride, Protector guard){
        this.name = name;
        this.ride = ride;
        this.guard = guard;
    }

    public void setRide(Flyable ride){
        this.ride = ride;
    }


    public void setGuard(Protector guard){
        this.guard = guard;
    }

    public String defend(){
        return this.guard.protect();
    }

    public String getName(){
        return this.name;
    }

    public Flyable getRide(){
        return this.ride;
    }

    public String fly(){
        return this.ride.fly();
    }

}

