package example.codeclan.com.checkpoint_1;

/**
 * Created by user on 29/08/2017.
 */

import static org.junit.Assert.*;
import org.junit.*;
import org.mockito.*;
import static org.mockito.Mockito.*;

public class GameTest {

    Game game;
    Rollable dice;

    @Before
    public void before(){
        dice = new FakeDice(6);
        game = new Game(dice);
    }

    @Test
    public void testTakeTurn(){
        boolean result = game.nextTurn();
        assertEquals(true, result);
    }

}

