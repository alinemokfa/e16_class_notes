package example.codeclan.com.composition_lab_solution;

/**
 * Created by user on 28/08/2017.
 */

import static org.junit.Assert.*;
import org.junit.*;

import example.codeclan.com.composition_lab_solution.wizard_management.Ogre;


public class OgreTest {

    Ogre ogre;

    @Before
    public void before(){
        ogre = new Ogre("Freddie");
    }

    @Test
    public void hasName(){
        assertEquals("Freddie", ogre.getName());
    }

    @Test
    public void canProtect(){
        assertEquals("Hitting with a massive mace", ogre.protect());
    }
}
