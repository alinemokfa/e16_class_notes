package example.codeclan.com.interfacesegregation;

/**
 * Created by user on 27/06/2017.
 */

import java.util.ArrayList;

public class Bear implements Bearable{

    // The Interface Segregation Principle states that:
    // "No client should be forced to depend on methods it does not use"

    // This Bear class has quite a few methods it probably won't use, I can't imagine the same Bear needing all of them.

    // It *must* implement all these methods as it's implementing the horribly bloated (and horribly named) "Bearable" interface.

    private ArrayList<Edible> belly = new ArrayList<Edible>();

    // pointless implementation
    public Seal iceFish(){
        return null;
    }

    // pointless implementation
    public String climbIceberg(){
        return null;
    }

    public int foodCount(){
        return belly.size();
    }

    public boolean isBellyFull(){
        return (foodCount() >= 5);
    }

    public Salmon riverFish(){
        return new Salmon();
    }

    public Honey harvestHoney(){
        return new Honey();
    }

    public Bamboo harvestBamboo(){
        return new Bamboo();
    }

    public String sleep(){
        return "Zzzzz...";
    }

    public String climbRock(){
        return "I'm on a rock, not much to do up here, nice spot for a sleep maybe.";
    }

    public String climbTree(){
        return "I can climb this tree, you can't hide from me!";
    }

    public void eat(Edible food){
        if (!isBellyFull()){
            belly.add(food);
        }
    }

}
