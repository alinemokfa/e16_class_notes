package example.codeclan.com.composition_lesson_end.wizard_management;

import example.codeclan.com.composition_lesson_end.behaviours.Flyable;

/**
 * Created by user on 28/08/2017.
 */

public class Dragon extends MythicalBeast implements Flyable {

    public Dragon(String name){
        super(name);
    }

    public String fly(){
        return "Standing up tall, beating wings, lift off!";
    }

}
