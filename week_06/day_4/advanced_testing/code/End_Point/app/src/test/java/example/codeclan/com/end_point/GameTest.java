package example.codeclan.com.end_point;

/**
 * Created by user on 29/08/2017.
 */

import static org.junit.Assert.*;


import org.junit.*;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;

public class GameTest {

    Game game;
    Rollable spyDice;

    @Before
    public void before(){
        Rollable dice = new Dice(6);
        spyDice = Mockito.spy(dice);
        game = new Game(spyDice);
    }

    @Test
    public void testTakeTurnStub(){
        Mockito.when(spyDice.roll()).thenReturn(2);

        boolean result = game.nextTurn();
        assertEquals(false, result);
    }

    @Test
    public void takeTurnMock(){
        Dice diceMock = mock(Dice.class);
        game = new Game(diceMock);
        game.nextTurn();
        verify(diceMock, times(1)).roll();
    }

}
