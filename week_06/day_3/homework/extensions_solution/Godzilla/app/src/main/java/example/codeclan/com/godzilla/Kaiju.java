package example.codeclan.com.godzilla;

import static android.R.attr.value;

public abstract class Kaiju {

    private String name;
    protected int healthValue;
    protected int attackValue;

    public Kaiju(String name, int healthValue, int attackValue) {
        this.name = name;
        this.healthValue = healthValue;
        this.attackValue = attackValue;
    }

    public String getName() {
        return this.name;
    }

    public int getHealthValue() {
        return this.healthValue;
    }

    public int getAttackValue() {
        return this.attackValue;
    }

    public void setHealthValue(int newHealthValue) {
        this.healthValue = newHealthValue;
    }

    public void subtractHealthValue(int valueToSubtract) {
        this.healthValue -= valueToSubtract;
    }


    public void attackVehicle(Vehicle vehicle) {
        vehicle.subtractHealthValue(this.getAttackValue());
    }

    public void attackBuilding(Building building){
        building.subtractHealthValue(this.getAttackValue());
    }

    public abstract String roar();

}