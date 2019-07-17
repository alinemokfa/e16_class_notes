package example.codeclan.com.composition_start;

/**
 * Created by user on 28/08/2017.
 */

import static org.junit.Assert.*;
import org.junit.*;

import example.codeclan.com.composition_start.wizard_management.*;


public class MagicCarpetTest {

    MagicCarpet magicCarpet;

    @Before
    public void before(){
        magicCarpet = new MagicCarpet("Yellow");
    }

    @Test
    public void hasColour(){
        assertEquals("Yellow", magicCarpet.getColour());
    }

    @Test
    public void canFly(){
        assertEquals("Hovering up, straightening out, flying off!", magicCarpet.fly());
    }

}
