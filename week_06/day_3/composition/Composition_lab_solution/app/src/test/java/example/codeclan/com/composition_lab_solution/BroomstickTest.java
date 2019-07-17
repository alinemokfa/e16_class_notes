package example.codeclan.com.composition_lab_solution;

/**
 * Created by user on 28/08/2017.
 */

import static org.junit.Assert.*;
import org.junit.*;

import example.codeclan.com.composition_lab_solution.wizard_management.*;


public class BroomstickTest {

    Broomstick broom;

    @Before
    public void before(){
        broom = new Broomstick("Nimbus",10);
    }

    @Test
    public void hasBrand(){
        assertEquals("Nimbus", broom.getBrand());
    }

    @Test
    public void hasSpeed(){
        assertEquals(10, broom.getSpeed());
    }

    @Test
    public void canFly(){
        assertEquals("mounting broom, running, skipping, flying!", broom.fly());
    }

}
