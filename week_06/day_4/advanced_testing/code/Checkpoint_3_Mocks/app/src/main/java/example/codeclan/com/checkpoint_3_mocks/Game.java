package example.codeclan.com.checkpoint_3_mocks;

/**
 * Created by user on 29/08/2017.
 */

public class Game {
    Rollable dice;
    int turnCount;

    public Game(Rollable dice) {
        this.dice = dice;
        this.turnCount = 0;
    }

    public boolean nextTurn(){
        int result = dice.roll();
        this.turnCount++;
        return result > 2;
    }

    public int getTurnCount(){
        return turnCount;
    }
}
