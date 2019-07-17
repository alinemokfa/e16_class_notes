package example.codeclan.com.multiple_class_end;

/**
 * Created by user on 28/08/2017.
 */

import static org.junit.Assert.assertEquals;
import org.junit.*;

public class BearTest{
    Bear bear;
    Salmon salmon;

    @Before
    public void before() {
        bear = new Bear("Baloo");
        salmon = new Salmon();
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
    public void bellyIsFull(){
        for(int i = 0; i<5; i++){
            bear.eat(salmon);
        }
        assertEquals(bear.isBellyFull(), true);
    }

    @Test
    public void canNotEatSalmonWhenBellyFull(){
        for(int i = 0; i<10; i++){
            bear.eat(salmon);
        }
        assertEquals(bear.foodCount(), 5);
    }

    @Test
    public void shouldEmptyBellyAfterSleeping(){
        bear.eat(salmon);
        bear.sleep();
        assertEquals(bear.foodCount(), 0);
    }
}

