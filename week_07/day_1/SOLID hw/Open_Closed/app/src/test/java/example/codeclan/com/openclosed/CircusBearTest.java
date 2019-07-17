package example.codeclan.com.openclosed;

/**
 * Created by user on 27/06/2017.
 */

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Before;

public class CircusBearTest{
    CircusBear circusBear;
    Salmon salmon;
    Steak steak;

    @Before
    public void before(){
        circusBear = new CircusBear();
        salmon = new Salmon();
        steak = new Steak();
    }

    @Test
    public void canEat(){
        circusBear.eat(salmon);
        assertEquals(1, circusBear.foodCount());
    }

    @Test
    public void cannotEatWhenBellyFull(){
        for (int i = 0; i < 12; i++){
            circusBear.eat(salmon);
        }
        assertEquals(10, circusBear.foodCount());
    }

    @Test
    public void cantEatSteak(){
        // This will cause a compilation error
        circusBear.eat(steak);
    }
}