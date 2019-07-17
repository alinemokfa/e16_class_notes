package example.codeclan.com.interfaceslabsolution;

/**
 * Created by user on 29/08/2017.
 */

import java.util.*;

public class Bear {

    private String name;
    private ArrayList<Edible> belly;

    public Bear(String name){
        this.name = name;
        this.belly = new ArrayList<Edible>();
    }

    public String getName(){
        return this.name;
    }

    public int foodCount(){
        return belly.size();
    }

    public void eat(Edible food){
        belly.add(food);
    }

    public void sleep(){
        belly.clear();
    }

    public Edible throwUp(){
        if(foodCount() > 0){
            return belly.remove(0);
        }
        return null;
    }

    public int totalNutrition(){
        int total = 0;
        for(Edible food : belly) {
            total += food.nutritionValue();
        }
        return total;
    }

}

