package example.codeclan.com.composition_lab_solution.wizard_management;

import example.codeclan.com.composition_lab_solution.behaviours.*;


/**
 * Created by user on 28/08/2017.
 */

public class Dragon extends MythicalBeast implements Flyable, Protector {

    public Dragon(String name){
        super(name);
    }

    public String fly(){
        return "Standing up tall, beating wings, lift off!";
    }

    public String protect(){
        return "Biting with sharp teeth";
    }

}
