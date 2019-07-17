package example.codeclan.com.start_point;

/**
 * Created by user on 29/08/2017.
 */

public class Game {
    Rollable dice;

    public Game(Rollable dice) {
        this.dice = dice;
    }

    public boolean nextTurn(){
        int result = dice.roll();
        return result > 2;
    }
}