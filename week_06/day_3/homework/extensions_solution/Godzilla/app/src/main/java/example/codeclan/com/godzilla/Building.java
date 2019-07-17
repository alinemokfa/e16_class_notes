package example.codeclan.com.godzilla;

/**
 * Created by user on 18/08/2017.
 */

public abstract class Building {

    private String type;
    private int healthValue;

    public Building(String type, int healthValue){
        this.type = type;
        this.healthValue = healthValue;
    }

    public int getHealthValue(){
        return this.healthValue;
    }


    public void subtractHealthValue(int attackValue){
        this.healthValue -= attackValue;
    }
}
