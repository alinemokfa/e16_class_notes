package example.codeclan.com.composition_lab_solution.wizard_management;

import example.codeclan.com.composition_lab_solution.behaviours.Flyable;

/**
 * Created by user on 28/08/2017.
 */

public class MagicCarpet extends Carpet implements Flyable {

    public MagicCarpet(String colour){
        super(colour);
    }

    public String fly(){
        return "Hovering up, straightening out, flying off!";
    }

}
