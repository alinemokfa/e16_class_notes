package example.codeclan.com.composition_start;

/**
 * Created by user on 28/08/2017.
 */

import static org.junit.Assert.*;
import org.junit.*;

import example.codeclan.com.composition_start.wizard_management.*;


public class DragonTest {

    Dragon dragon;

    @Before
    public void before(){
        dragon = new Dragon("Bob");
    }

    @Test
    public void hasName(){
        assertEquals("Bob", dragon.getName());
    }

    @Test
    public void canFly(){
        assertEquals("Standing up tall, beating wings, lift off!", dragon.fly());
    }
}
