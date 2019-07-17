package example.codeclan.com.composition_start.wizard_management;

/**
 * Created by user on 28/08/2017.
 */

public abstract class Carpet {

    String colour;

    public Carpet(String colour){
        this.colour = colour;
    }

    public String getColour(){
        return this.colour;
    }
}
