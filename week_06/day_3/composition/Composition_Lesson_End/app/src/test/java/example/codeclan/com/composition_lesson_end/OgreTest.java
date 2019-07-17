package example.codeclan.com.composition_lesson_end;

/**
 * Created by user on 28/08/2017.
 */

import static org.junit.Assert.*;
import org.junit.*;

import example.codeclan.com.composition_lesson_end.wizard_management.Ogre;


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
