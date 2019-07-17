package example.codeclan.com.checkpoint_1;

/**
 * Created by user on 29/08/2017.
 */

import java.util.*;

public class Dice implements Rollable {

    int numberOfSides;

    public Dice(int numberOfSides) {
        this.numberOfSides = numberOfSides;
    }

    public int roll(){
        return randomNumber(1, this.numberOfSides);
    }

    private int randomNumber(int min, int max){
        Random rand = new Random();
        int result = rand.nextInt((max - min) + 1) + min;
        return result;
    }
}
