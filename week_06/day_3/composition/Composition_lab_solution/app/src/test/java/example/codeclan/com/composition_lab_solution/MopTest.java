package example.codeclan.com.composition_lab_solution;

/**
 * Created by user on 28/08/2017.
 */

import static org.junit.Assert.*;
import org.junit.*;

import example.codeclan.com.composition_lab_solution.wizard_management.Mop;


public class MopTest {

    Mop mop;

    @Before
    public void before(){
        mop = new Mop("Hygenic");
    }

    @Test
    public void hasBrand(){
        assertEquals("Hygenic", mop.getBrand());
    }

}