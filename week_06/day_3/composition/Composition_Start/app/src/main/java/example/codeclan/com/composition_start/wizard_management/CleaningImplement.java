package example.codeclan.com.composition_start.wizard_management;

/**
 * Created by user on 28/08/2017.
 */

public abstract class CleaningImplement{

    String brand;

    public CleaningImplement(String brand) {
        this.brand = brand;
    }

    public String getBrand(){
        return this.brand;
    }
}
