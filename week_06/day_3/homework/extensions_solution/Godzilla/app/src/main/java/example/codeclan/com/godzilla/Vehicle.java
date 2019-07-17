package example.codeclan.com.godzilla;

import static android.R.attr.type;

public abstract class Vehicle implements Attack {

    protected int healthValue;
    protected int attackValue;

    public Vehicle(int healthValue, int attackValue) {
        this.healthValue = healthValue;
        this.attackValue = attackValue;
    }

    public int getHealthValue(){
        return this.healthValue;
    }


    public void subtractHealthValue(int valueToSubtract){
        this.healthValue -= valueToSubtract;
    }




}
