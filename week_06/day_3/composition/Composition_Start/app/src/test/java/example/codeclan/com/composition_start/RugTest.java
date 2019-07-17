package example.codeclan.com.composition_start;

/**
 * Created by user on 28/08/2017.
 */

import static org.junit.Assert.*;
import org.junit.*;

import example.codeclan.com.composition_start.wizard_management.*;


public class RugTest {

    Rug rug;

    @Before
    public void before(){
        rug = new Rug("Yellow");
    }

    @Test
    public void hasColour(){
        assertEquals("Yellow",rug.getColour());
    }

}
