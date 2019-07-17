package example.codeclan.com.composition_lab_solution.wizard_management;

import example.codeclan.com.composition_lab_solution.behaviours.Protector;

/**
 * Created by user on 28/08/2017.
 */


public class Ogre extends MythicalBeast implements Protector {

    public Ogre(String name){
        super(name);
    }

    public String protect(){
        return "Hitting with a massive mace";
    }

}
