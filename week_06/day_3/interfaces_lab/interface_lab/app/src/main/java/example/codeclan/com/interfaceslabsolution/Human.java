package example.codeclan.com.interfaceslabsolution;

/**
 * Created by user on 29/08/2017.
 */

public class Human implements Edible {

    public String speak(){
        return "speaking";
    }

    public String swim(){
        return "swimming";
    }

    public int nutritionValue(){
        return 10;
    }

}
