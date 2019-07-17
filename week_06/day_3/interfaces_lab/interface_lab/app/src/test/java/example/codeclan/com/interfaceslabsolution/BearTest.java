package example.codeclan.com.interfaceslabsolution;

/**
 * Created by user on 29/08/2017.
 */

import static org.junit.Assert.*;
import org.junit.*;

public class BearTest{
    Bear bear;
    Salmon salmon;
    Human human;
    Chicken chicken;

    @Before
    public void before() {
        bear = new Bear("Baloo");
        salmon = new Salmon();
        human = new Human();
        chicken = new Chicken();
    }

    @Test
    public void hasName(){
        assertEquals( "Baloo", bear.getName() );
    }

    @Test
    public void bellyStartsEmpty(){
        assertEquals(0, bear.foodCount());
    }

    @Test
    public void canEatSalmon(){
        bear.eat(salmon);
        assertEquals(1, bear.foodCount());
    }

    @Test
    public void canEatHuman(){
        bear.eat(human);
        assertEquals(1, bear.foodCount());
    }

    @Test
    public void shouldEmptyBellyAfterSleeping(){
        bear.eat(salmon);
        bear.sleep();
        assertEquals(bear.foodCount(), 0);
    }

    @Test
    public void canThrowUpSalmon() {
        bear.eat(salmon);
        Edible food = bear.throwUp();
        Salmon original = (Salmon)food;
        assertEquals("swimming",original.swim());
    }

    @Test
    public void canThrowUpChicken() {
        bear.eat(chicken);
        Edible food = bear.throwUp();
        Chicken original = (Chicken)food;
        assertEquals("Kweh!",original.cluck());
    }

    @Test
    public void returnsTotalNutrition(){
        bear.eat(salmon);
        bear.eat(human);
        assertEquals(bear.totalNutrition(), 12);
    }
}

