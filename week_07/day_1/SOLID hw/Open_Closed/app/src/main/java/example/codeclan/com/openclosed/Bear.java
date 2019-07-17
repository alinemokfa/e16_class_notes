package example.codeclan.com.openclosed;

/**
 * Created by user on 27/06/2017.
 */

import java.util.ArrayList;

// Open / Closed Principle:
// Our classes should be "Open for extension, closed for modification"

// Our Bear class' eat method only takes Salmon type objects, so we can't extend it to eat anything else.
// If we inherit from Bear and want to make it eat something else, then we're out of luck.
// This Bear (and therefore also any subclasses which want to extend it) only eats Salmon. Not very extensible.

public class Bear{

    private ArrayList<Salmon> belly = new ArrayList<Salmon>();

    public void eat(Salmon food){
        if (!isBellyFull()){
            belly.add(food);
        }
    }

    public int foodCount(){
        return belly.size();
    }

    public boolean isBellyFull(){
        return (foodCount() >= 10);
    }

}
