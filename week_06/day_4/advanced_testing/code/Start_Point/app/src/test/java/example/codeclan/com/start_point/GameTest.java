package example.codeclan.com.start_point;

/**
 * Created by user on 29/08/2017.
 */

import static org.junit.Assert.*;
import org.junit.*;

public class GameTest {

    Game game;
    Rollable dice;

    @Before
    public void before(){
        dice = new Dice(6);
        game = new Game(dice);
    }

    @Test
    public void testTakeTurn(){
        boolean result = game.nextTurn();
        assertEquals(true, result);
    }

}
