package example.codeclan.com.composition_start;

/**
 * Created by user on 28/08/2017.
 */

import static org.junit.Assert.*;
import org.junit.*;

import example.codeclan.com.composition_start.wizard_management.*;


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
}
