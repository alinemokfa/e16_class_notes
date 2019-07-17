package example.codeclan.com.composition_start.wizard_management;

/**
 * Created by user on 28/08/2017.
 */

public abstract class MythicalBeast {

    String name;

    public MythicalBeast(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}
